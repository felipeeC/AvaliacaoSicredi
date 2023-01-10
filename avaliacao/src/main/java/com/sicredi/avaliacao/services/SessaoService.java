package com.sicredi.avaliacao.services;
import com.sicredi.avaliacao.Conversores.ConversorSessao;
import com.sicredi.avaliacao.dtos.SessaoForm;
import com.sicredi.avaliacao.models.Pauta;
import com.sicredi.avaliacao.models.Sessao;
import com.sicredi.avaliacao.repositories.SessaoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.*;
@Service
public class SessaoService {
    @Autowired
    private SessaoRepository sessaoRepository;
    @Autowired
    private PautaService pautaService;


    public Sessao criaSessao(@Valid SessaoForm form, Long idPauta){
        Sessao sessao = converteSessaoForm(form);
        Date date = new Date(System.currentTimeMillis());
        //System.out.println("DATA DA SESSAO: "+date+ " DATA FIM: "+form.getDataFim());
        sessao.setDataInicio(date);

        if(form.getDataFim() == null){
            sessao.setDafaFim(addMinutosJavaUtilDate(date));
        }else{
            if (verificaDatas(sessao.getDafaFim(), sessao.getDataInicio())){
                return null;
            }
        }

        sessaoRepository.save(sessao);
        associaPauta(sessao.getId(),idPauta);
        return sessao;
    }
    public void associaPauta(Long idSessao, Long idPauta){
        Pauta pauta = pautaService.getPautaById(idPauta);
        Optional<Sessao> sessao = Optional.ofNullable(getSessaoById(idSessao));

        sessao.get().getPautas().add(pauta);
        sessaoRepository.save(sessao.get());
    }
    public boolean verificaDatas(Date dataFim, Date dataInicio){
        boolean result = dataFim.getTime() < dataInicio.getTime();
        return result;
    }
    public Date addMinutosJavaUtilDate(Date date) {
        int minutos=1;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutos);
        return calendar.getTime();
    }
    public Sessao converteSessaoForm(SessaoForm form){
        Sessao sessao = form.converter();
        return sessao;
    }

    public Sessao getSessaoById(Long id){
        Optional<Sessao> obj = sessaoRepository.findById(id);
        return obj.orElseThrow(
                () -> new ObjectNotFoundException("Sessão Não Encontrada! id:"  + id, ""));
    }
    public List<Sessao> imprimirSessoes() {
        return sessaoRepository.findAll();
    }
    public boolean verificarSeSessaoExiste(Long id){
        return sessaoRepository.findById(id).isPresent();
    }
}
