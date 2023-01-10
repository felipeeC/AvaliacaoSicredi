package com.sicredi.avaliacao.models;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Sessao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataInicio;
    private LocalDateTime dafaFim;
    @ManyToMany
    private List<Pauta> pautas = new ArrayList<>();
    @ManyToMany
    private List<Voto> votos = new ArrayList<>();

    public Sessao(){
        super();
    }
    public Sessao( LocalDateTime dataFim){
        super();
        this.dafaFim=dataFim;

    }

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
    public LocalDateTime getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }
    public LocalDateTime getDafaFim() {
        return dafaFim;
    }
    public void setDafaFim(LocalDateTime dafaFim) {
        this.dafaFim = dafaFim;
    }
    @Override
    public String toString() {
        return this.id + "\t" + this.dataInicio + "\t\t" + this.dafaFim;
    }
}

