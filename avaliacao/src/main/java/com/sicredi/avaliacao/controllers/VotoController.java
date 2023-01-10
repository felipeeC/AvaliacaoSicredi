package com.sicredi.avaliacao.controllers;
import com.sicredi.avaliacao.dtos.VotoDto;
import com.sicredi.avaliacao.dtos.VotoForm;
import com.sicredi.avaliacao.services.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping(value = "/votar")
public class VotoController {
    @Autowired
    private VotoService votoService;
    @PostMapping
    public ResponseEntity<VotoDto> votar(@RequestBody @Valid VotoForm form) {
        if(votoService.validarRequest(form)){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
       return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    @GetMapping(value = "/contabilizar/{idSessao}")
    public ResponseEntity<String> contabilizarVotos(@PathVariable(name = "idSessao")Long idSessao){
        return new ResponseEntity<String>(votoService.contabilizarVotos(idSessao), HttpStatus.OK);
    }
}
