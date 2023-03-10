package com.sicredi.avaliacao.dtos;
import javax.validation.constraints.NotNull;
public class VotoForm {
    @NotNull
    private String cpf;
    @NotNull
    private String resposta;
    @NotNull
    private Long idSessao;

    public VotoForm(String cpf, String resposta, Long idSessao){
        this.cpf=cpf;
        this.resposta=resposta;
        this.idSessao=idSessao;
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
    public String getResposta() {
        return resposta;
    }
    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
