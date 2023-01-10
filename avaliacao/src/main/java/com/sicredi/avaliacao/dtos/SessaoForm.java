package com.sicredi.avaliacao.dtos;
import com.sicredi.avaliacao.models.Sessao;
import java.time.LocalDateTime;

public class SessaoForm {
    private LocalDateTime dataFim;
    public SessaoForm(){
        super();
    }

    public SessaoForm( LocalDateTime dataFim){
        this.dataFim=dataFim;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

}
