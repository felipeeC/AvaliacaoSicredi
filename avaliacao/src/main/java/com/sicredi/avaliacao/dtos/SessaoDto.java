package com.sicredi.avaliacao.dtos;
import com.sicredi.avaliacao.models.Sessao;
import java.time.LocalDateTime;

public class SessaoDto {
    private Long id;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    public SessaoDto(){
        super();
    }
    public SessaoDto(Sessao sessao){
        super();
        this.id = sessao.getId();
        this.dataInicio= sessao.getDataInicio();
        this.dataFim = sessao.getDafaFim();

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
    public LocalDateTime getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }
}
