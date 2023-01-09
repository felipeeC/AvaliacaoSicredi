package com.sicredi.avaliacao.controllers;

import com.sicredi.avaliacao.dtos.PautaDto;
import com.sicredi.avaliacao.dtos.SessaoDto;
import com.sicredi.avaliacao.dtos.SessaoForm;
import com.sicredi.avaliacao.models.Pauta;
import com.sicredi.avaliacao.models.Sessao;
import com.sicredi.avaliacao.services.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/sessoes")
public class SessaoController {
    @Autowired
    private SessaoService sessaoService;
    @PostMapping(value = "/iniciar/{idPauta}")
    public ResponseEntity<SessaoDto> iniciar(@RequestBody @Valid SessaoForm form, @PathVariable(name = "idPauta")Long idPauta, UriComponentsBuilder uriBuilder) {
        Sessao sessaoNova = sessaoService.criaSessao(form, idPauta);
        if (sessaoNova != null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
            //URI uri = uriBuilder.path("/sessoes/{id}").buildAndExpand(sessaoNova.getId()).toUri();
            //return ResponseEntity.created(uri).body(new SessaoDto(sessaoNova));
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping
    public List<SessaoDto> todasSessoes(){
        List<Sessao> sessoes = sessaoService.imprimeSessoes();
        return SessaoDto.converter(sessoes);
    }
}
