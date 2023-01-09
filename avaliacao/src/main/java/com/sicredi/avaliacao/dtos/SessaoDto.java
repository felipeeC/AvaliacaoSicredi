package com.sicredi.avaliacao.dtos;

import com.sicredi.avaliacao.models.Sessao;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SessaoDto {
    private Long id;
    private Date dataInicio;
    private Date dataFim;

    public SessaoDto(){
        super();
    }
    public SessaoDto(Sessao sessao){
        super();
        this.id = sessao.getId();
        this.dataInicio= sessao.getDataInicio();
        this.dataFim = sessao.getDafaFim();

    }

    public static List<SessaoDto> converter(List<Sessao> sessoes){
        return sessoes.stream().map(SessaoDto::new).collect(Collectors.toList());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }


}
