package com.sicredi.avaliacao.services;
import com.sicredi.avaliacao.dtos.VotoForm;
import com.sicredi.avaliacao.models.Sessao;
import com.sicredi.avaliacao.models.Voto;
import com.sicredi.avaliacao.Conversores.ConversorVoto;
import com.sicredi.avaliacao.repositories.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;
@Service
public class VotoService {
    @Autowired
    private SessaoService sessaoService;
    @Autowired
    private VotoRepository votoRepository;
    public Voto votar(@Valid VotoForm form){
        Voto voto = ConversorVoto.converterVotoFormEmVoto(form.getCpf(), form.getResposta(), form.getIdSessao());
        voto.setDataVoto(LocalDateTime.now());
        voto.setCpf(form.getCpf());
        voto.setResposta(form.getResposta());
        voto.setIdSessao(form.getIdSessao());
        votoRepository.save(voto);
        return voto;
    }
    public boolean verificarSeJaVotou(VotoForm form){
        List<Voto> votos = votoRepository.findAll();
        boolean validador=false;
        for (Voto votoList : votos) {
            if(votoList.getCpf().equals(form.getCpf())  && votoList.getIdSessao().equals(form.getIdSessao())){
                 validador = true;
            }else {
                validador = false;
            }
        }
        return validador;
    }
    public String contabilizarVotos(Long idSessao) {
        List<Voto>votos = votoRepository.findAll();
        int contadorSim = 0;
        int contadorNao = 0;
        for (Voto voto : votos) {
            if(voto.getIdSessao() == idSessao){
                if (voto.getResposta().equals("sim")) {
                    contadorSim+=1;
                }else {
                    contadorNao += 1;
                }
            }
        }
        return ("Votos SIM: " + contadorSim + " Votos NÃO: " + contadorNao);
    }
    public boolean validarRequest(VotoForm form){
        if(form.getIdSessao()==null){
            return false;
        }
        if(!sessaoService.verificarSeSessaoExiste(form.getIdSessao())){
            return false;
        }
        Sessao sessao=sessaoService.BuscarSessaoPorId(form.getIdSessao());
        if(form==null){
            return false;
        }
        if(sessao.getDafaFim().isBefore(LocalDateTime.now())){
            return false;
        }
        if(!validarCpf(form.getCpf())){
            return false;
        }
        if(!(form.getResposta().equals("sim") || form.getResposta().equals("não"))){
            return false;
        }
        if(verificarSeJaVotou(form)){
            return false;
        }
        if(form.getCpf() == null){
            return false;
        }
        if(form.getResposta() == ""){
            return false;
        }else{
            votar(form);
            return true;
        }
    }
    public static boolean validarCpf(String CPF) {
        if (CPF.equals("00000000000") ||
                CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999") ||
                (CPF.length() != 11))
            return(false);
        char dig10, dig11;
        int sm, i, r, num, peso;
        try {
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48);
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }
}



