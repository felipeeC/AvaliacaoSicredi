package com.sicredi.avaliacao.dtos;

import com.sicredi.avaliacao.models.Pauta;

import java.util.List;
import java.util.stream.Collectors;

public class PautaDto {
    private Long id;
    private String nome;
    private String descricao;



    public PautaDto(Pauta pauta){
        super();
        this.id= pauta.getId();
        this.nome= pauta.getNome();
        this.descricao= pauta.getDescricao();
    }

    public Long getId() {
        return id;
    }



    public String getNome() {
        return nome;
    }



    public String getDescricao() {
        return descricao;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public static List<PautaDto> converter(List<Pauta> pautas){
        return pautas.stream().map(PautaDto::new).collect(Collectors.toList());
    }
}
