package com.sicredi.avaliacao.Conversores;
import com.sicredi.avaliacao.models.Voto;

public class ConversorVoto {
    public static Voto converterVotoFormEmVoto(String cpf, String resposta, Long idSessao){
        return new Voto(cpf,resposta, idSessao);
    }
}
