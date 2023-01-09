package com.sicredi.avaliacao.controllers;


import com.sicredi.avaliacao.dtos.PautaDto;
import com.sicredi.avaliacao.dtos.VotoDto;
import com.sicredi.avaliacao.dtos.VotoForm;
import com.sicredi.avaliacao.models.Sessao;
import com.sicredi.avaliacao.models.Voto;
import com.sicredi.avaliacao.services.SessaoService;
import com.sicredi.avaliacao.services.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/votar")
public class VotoController {
    @Autowired
    private SessaoService sessaoService;
    @Autowired
    private VotoService votoService;
    @PostMapping
    public ResponseEntity<VotoDto> iniciar(@RequestBody @Valid VotoForm form, UriComponentsBuilder uriBuilder) {

        if(votoService.validaRequest(form)){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else {
           return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
    @GetMapping(value = "/contabilizar/{idSessao}")
    public ResponseEntity<String> contabilizarVotos(@PathVariable(name = "idSessao")Long idSessao){
        String resultado = votoService.contabilizaVotos(idSessao);

        System.out.println(resultado);
        return new ResponseEntity<String>(resultado, HttpStatus.OK);
    }


}
