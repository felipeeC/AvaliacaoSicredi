package com.sicredi.avaliacao.dtos;

import com.sicredi.avaliacao.models.Voto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class VotoDto {
    private Long id;
    private String cpf;
    private Date dataVoto;
    private String resposta;

    private Long idSessao;

    public VotoDto(Voto voto){
        super();
        this.id= voto.getId();
        this.cpf= voto.getCpf();
        this.dataVoto = voto.getDataVoto();
        this.resposta = voto.getResposta();
        this.idSessao = voto.getIdSessao();
    }

    public static List<VotoDto> converter(List<Voto> votos){
        return votos.stream().map(VotoDto::new).collect(Collectors.toList());
    }


    public Long getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(Long idSessao) {
        this.idSessao = idSessao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataVoto() {
        return dataVoto;
    }

    public void setDataVoto(Date dataVoto) {
        this.dataVoto = dataVoto;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
