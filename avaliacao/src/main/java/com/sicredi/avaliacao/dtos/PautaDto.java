package com.sicredi.avaliacao.dtos;

import com.sicredi.avaliacao.models.Pauta;

import java.util.List;
import java.util.stream.Collectors;

public class PautaDto {
    private Long id;
    private String titulo;
    private String descricao;



    public PautaDto(Pauta pauta){
        super();
        this.id= pauta.getId();
        this.titulo = pauta.getTitulo();
        this.descricao= pauta.getDescricao();
    }

    public Long getId() {
        return id;
    }



    public String getTitulo() {
        return titulo;
    }



    public String getDescricao() {
        return descricao;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public static List<PautaDto> converter(List<Pauta> pautas){
        return pautas.stream().map(PautaDto::new).collect(Collectors.toList());
    }
}
