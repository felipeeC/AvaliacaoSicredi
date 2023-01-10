package com.sicredi.avaliacao.Conversores;
import com.sicredi.avaliacao.dtos.SessaoDto;
import com.sicredi.avaliacao.dtos.SessaoForm;
import com.sicredi.avaliacao.models.Sessao;
import java.util.List;
import java.util.stream.Collectors;

public class ConversorSessao {
    public static List<SessaoDto> converterParaSessaoDto(List<Sessao> sessoes){
        return sessoes.stream().map(SessaoDto::new).collect(Collectors.toList());
    }

    public static Sessao converterSessaoFormParaSessao(SessaoForm form){
        return new Sessao();
    }
}
