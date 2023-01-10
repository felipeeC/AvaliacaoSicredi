package com.sicredi.avaliacao.Conversores;
import com.sicredi.avaliacao.dtos.PautaDto;
import com.sicredi.avaliacao.models.Pauta;
import java.util.List;
import java.util.stream.Collectors;

public class ConversorPauta {
    public static List<PautaDto> converterPautaParaPautaDto(List<Pauta> pautas){
        return pautas.stream().map(PautaDto::new).collect(Collectors.toList());
    }
    public static Pauta converterPautaFormParaPauta(String titulo,String descricao){
        return new Pauta(titulo,descricao);
    }
}
