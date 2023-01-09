package com.sicredi.avaliacao.models;

import javax.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Sessao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataInicio;
    private Date dafaFim;

    @ManyToMany
    private List<Pauta> pautas = new ArrayList<>();
    @ManyToMany
    private List<Voto> votos = new ArrayList<>();

    //Constructors
    public Sessao(){
        super();
    }

    public Sessao( Date dataFim){
        super();
        this.dafaFim=dataFim;

    }

    //Getters e Setters
    public List<Pauta> getPautas() {
        return pautas;
    }
    public void setPautas(List<Pauta> pautas) {
        this.pautas = pautas;
    }
    public List<Voto> getVotos() {
        return votos;
    }
    public void setVotos(List<Voto> votos) {
        this.votos = votos;
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
    public Date getDafaFim() {
        return dafaFim;
    }
    public void setDafaFim(Date dafaFim) {
        this.dafaFim = dafaFim;
    }
    @Override
    public String toString() {
        return this.id + "\t" + this.dataInicio + "\t\t" + this.dafaFim;
    }
}

