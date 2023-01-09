package com.sicredi.avaliacao.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
public class Voto {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private Date dataVoto;
    private String resposta;
    private Long idSessao;

    @ManyToMany
    private List<Sessao> sessoes = new ArrayList<>();



    public Voto(){
        super();
    }

    public Voto( String cpf, String resposta, Long idSessao){
        super();
        this.cpf = cpf;
        this.resposta =resposta;
        this.idSessao =idSessao;
    }

    public Long getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(Long idSessao) {
        this.idSessao = idSessao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Sessao> getSessoes() {
        return sessoes;
    }

    public void setSessoes(List<Sessao> sessoes) {
        this.sessoes = sessoes;
    }

    @Override
    public String toString() {
        return this.cpf + "\t" + this.dataVoto + "\t\t" + this.resposta + "\t\t" + this.idSessao;
    }
}
