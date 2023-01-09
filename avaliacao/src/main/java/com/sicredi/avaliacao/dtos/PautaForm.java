package com.sicredi.avaliacao.dtos;
import com.sicredi.avaliacao.models.Pauta;

import javax.validation.constraints.NotNull;


public class PautaForm {
    @NotNull
    private String nome;
    @NotNull
    private String descricao;

    public PautaForm(@NotNull String nome, @NotNull String descricao){
        this.nome=nome;
        this.descricao=descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pauta converter(){
        return new Pauta(nome,descricao);
    }
}
