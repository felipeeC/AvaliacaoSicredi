package com.sicredi.avaliacao.services;

import com.sicredi.avaliacao.dtos.VotoForm;
import com.sicredi.avaliacao.models.Sessao;
import com.sicredi.avaliacao.models.Voto;
import com.sicredi.avaliacao.repositories.VotoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
@Service
public class VotoService {
    @Autowired
    private SessaoService sessaoService;
    @Autowired
    private VotoRepository votoRepository;
    public Voto votar(@Valid VotoForm form){
        Voto voto = converteVotoForm(form);
        Date date = new Date(System.currentTimeMillis());
        voto.setDataVoto(date);
        voto.setCpf(form.getCpf());
        voto.setResposta(form.getResposta());
        voto.setIdSessao(form.getIdSessao());
        votoRepository.save(voto);
        return voto;
    }

    public boolean verificaVotoSeExiste(VotoForm form){
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
    public Voto converteVotoForm(VotoForm form){
        Voto voto = form.converter();
        return voto;
    }

    public String contabilizaVotos(Long idSessao) {

        List<Voto>votos = votoRepository.findAll();

        int contadorSim = 0;
        int contadorNao = 0;
        for (Voto voto : votos) {


            if(voto.getIdSessao() == idSessao){

                if (voto.getResposta().equals("sim")) {

                    contadorSim+=1;
                }
                if (voto.getResposta().equals("não")) {
                    contadorNao+=1;
                }

            }
        }

        String Resultado = ("Votos SIM: " + contadorSim + " Votos NÃO: " + contadorNao);
        return Resultado;
    }
    public boolean validaRequest(VotoForm form){

        if(!sessaoService.verificaSessaoIfExist(form.getIdSessao())){
            return false;
        }
        Sessao sessao=sessaoService.getSessaoById(form.getIdSessao());
        Date date = new Date(System.currentTimeMillis());
        if(form==null){
            return false;
        }
        if(sessao.getDafaFim().getTime()< date.getTime()){
            return false;
        }
        if(!validaCPF(form.getCpf())){
            return false;
        }
        if(!(form.getResposta().equals("sim") || form.getResposta().equals("não"))){
            return false;
        }
        if(verificaVotoSeExiste(form)){
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

    public static boolean validaCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
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

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                // converte o caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
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

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }


}


