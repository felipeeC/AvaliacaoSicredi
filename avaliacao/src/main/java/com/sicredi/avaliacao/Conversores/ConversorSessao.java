package com.sicredi.avaliacao.Conversores;
import com.sicredi.avaliacao.dtos.SessaoDto;
import com.sicredi.avaliacao.models.Sessao;
import java.util.List;
import java.util.stream.Collectors;

public class ConversorSessao {
    public static List<SessaoDto> converter(List<Sessao> sessoes){
        return sessoes.stream().map(SessaoDto::new).collect(Collectors.toList());
    }
}
