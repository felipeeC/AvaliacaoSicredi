package com.sicredi.avaliacao.dtos;
import com.sicredi.avaliacao.models.Pauta;

import javax.validation.constraints.NotNull;


public class PautaForm {
    @NotNull
    private String titulo;
    @NotNull
    private String descricao;

    public PautaForm(@NotNull String titulo, @NotNull String descricao){
        this.titulo =titulo;
        this.descricao=descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pauta converter(){
        return new Pauta(titulo,descricao);
    }
}
