package com.sicredi.avaliacao.services;

import com.sicredi.avaliacao.dtos.PautaForm;
import com.sicredi.avaliacao.models.Pauta;
import com.sicredi.avaliacao.repositories.PautaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PautaService {

    @Autowired
    private PautaRepository pautaRepository;
    public Pauta convertePautaForm(PautaForm pautaForm){
        Pauta pauta = pautaForm.converter();
        return pauta;
    }
    public Pauta cria(@Valid PautaForm form){
        Pauta novaPauta = convertePautaForm(form);
        List<Pauta> pautas = pautaRepository.findAll();
        if(pautas.contains(novaPauta)){
            return null;
        }
        pautaRepository.save(novaPauta);
        return novaPauta;



    }
    public Pauta getPautaById(Long id){
        Optional<Pauta> obj = pautaRepository.findById(id);

        return obj.orElseThrow(
                () -> new ObjectNotFoundException("Pauta Não Encontrada! id:"  + id, ""));
    }
    public List<Pauta> imprimePautas() {
        List<Pauta> pautas = pautaRepository.findAll();
        return pautas;
    }
}