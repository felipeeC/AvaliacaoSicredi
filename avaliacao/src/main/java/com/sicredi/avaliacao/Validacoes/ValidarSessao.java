package com.sicredi.avaliacao.Validacoes;

import com.sicredi.avaliacao.Conversores.ConversorSessao;
import com.sicredi.avaliacao.dtos.SessaoForm;
import com.sicredi.avaliacao.models.Sessao;
import com.sicredi.avaliacao.services.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
@
public class ValidarSessao {
    @Autowired
    private SessaoService sessaoService;
    public Sessao validarSessao(SessaoForm form, Long idPauta){
        Sessao sessao = ConversorSessao.converterSessaoFormParaSessao(form);
        sessao.setDataInicio(LocalDateTime.now());
        if(form.getDataFim() == null){
            sessao.setDafaFim(LocalDateTime.now().plusMinutes(1));

            return sessao;
        }
        if (sessao.getDafaFim().isBefore(sessao.getDataInicio())){
            return null;
        }
        else {
            sessaoService.criarSessao(sessao, idPauta);
            return sessao;
        }
    }
}
