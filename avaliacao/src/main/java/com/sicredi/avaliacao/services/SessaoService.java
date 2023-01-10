package com.sicredi.avaliacao.services;
import com.sicredi.avaliacao.Conversores.ConversorSessao;
import com.sicredi.avaliacao.dtos.SessaoForm;
import com.sicredi.avaliacao.models.Sessao;
import com.sicredi.avaliacao.repositories.SessaoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.*;
@Service
public class SessaoService {
    @Autowired
    private SessaoRepository sessaoRepository;
    @Autowired
    private PautaService pautaService;

    public Sessao criarSessao(SessaoForm form, Long idPauta){
        Sessao sessao = ConversorSessao.converterSessaoFormParaSessao(form);
        sessao.setDataInicio(LocalDateTime.now());
        if(form.getDataFim() == null){
            sessao.setDafaFim(LocalDateTime.now().plusMinutes(1));
            sessaoRepository.save(sessao);
            return sessao;
        }
        if (sessao.getDafaFim().isBefore(sessao.getDataInicio())){
            return null;
        }
        else {
            sessaoRepository.save(sessao);
            associarPauta(sessao.getId(),idPauta);
            return sessao;
        }
    }
    public void associarPauta(Long idSessao, Long idPauta){
        Optional<Sessao> sessao = Optional.ofNullable(BuscarSessaoPorId(idSessao));
        sessao.get().getPautas().add(pautaService.buscarPautaPorId(idPauta));
        sessaoRepository.save(sessao.get());
    }
    public Sessao BuscarSessaoPorId(Long id){
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
