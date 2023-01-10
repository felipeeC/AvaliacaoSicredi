package com.sicredi.avaliacao.services;
import com.sicredi.avaliacao.dtos.PautaForm;
import com.sicredi.avaliacao.models.Pauta;
import com.sicredi.avaliacao.Conversores.ConversorPauta;
import com.sicredi.avaliacao.repositories.PautaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@Service
public class PautaService {
    @Autowired
    private PautaRepository pautaRepository;
    public Pauta convertePautaFormParaPauta(PautaForm pautaForm){
        return ConversorPauta.converterPautaFormParaPauta(pautaForm.getTitulo(),pautaForm.getDescricao());
    }
    public Pauta criarPauta(@Valid PautaForm form){
        Pauta novaPauta = convertePautaFormParaPauta(form);
        List<Pauta> pautas = pautaRepository.findAll();
        if(pautas.contains(novaPauta)){
            return null;
        }
        pautaRepository.save(novaPauta);
        return novaPauta;
    }
    public Pauta buscarPautaPorId(Long id){
        Optional<Pauta> obj = pautaRepository.findById(id);

        return obj.orElseThrow(
                () -> new ObjectNotFoundException("Pauta Não Encontrada! id:"  + id, ""));
    }
    public List<Pauta> imprimirPautas() {
        List<Pauta> pautas = pautaRepository.findAll();
        return pautas;
    }
}