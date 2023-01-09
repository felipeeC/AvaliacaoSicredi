package com.sicredi.avaliacao.dtos;

import com.sicredi.avaliacao.models.Pauta;
import com.sicredi.avaliacao.models.Sessao;


import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class SessaoForm {


    private Date dataFim;


    public SessaoForm(){
        super();
    }
    public SessaoForm( Date dataFim){
        this.dataFim=dataFim;
    }



    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }




    public Sessao converter(){
        return new Sessao(dataFim);
    }
}
