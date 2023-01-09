package com.sicredi.avaliacao.controllers;

import com.sicredi.avaliacao.dtos.PautaDto;
import com.sicredi.avaliacao.dtos.PautaForm;
import com.sicredi.avaliacao.models.Pauta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sicredi.avaliacao.services.PautaService;
import org.springframework.web.util.UriComponentsBuilder;
import com.sicredi.avaliacao.dtos.PautaDto;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/pautas")
public class PautaController {
    @Autowired
    private PautaService pautaService;

    @PostMapping
    public ResponseEntity<PautaDto> cadastrar(@RequestBody @Valid PautaForm form,UriComponentsBuilder uriBuilder) {
        Pauta pautaNova = pautaService.cria(form);
        if (pautaNova != null && !pautaNova.getNome().equals("")) {
            //return ResponseEntity.status(HttpStatus.CREATED).build();
            URI uri = uriBuilder.path("/pautas/{id}").buildAndExpand(pautaNova.getId()).toUri();
            return ResponseEntity.created(uri).body(new PautaDto(pautaNova));
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping
    public List<PautaDto> todasPautas(){
        List<Pauta> pautas = pautaService.imprimePautas();
        return PautaDto.converter(pautas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PautaDto> getPautaById(@PathVariable(name = "id") long id){
     Pauta pauta= pautaService.getPautaById(id);
     return ResponseEntity.ok(new PautaDto(pauta));
    }

}
