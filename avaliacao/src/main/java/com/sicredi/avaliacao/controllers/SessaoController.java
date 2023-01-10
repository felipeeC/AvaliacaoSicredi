package com.sicredi.avaliacao.controllers;
import com.sicredi.avaliacao.Conversores.ConversorSessao;
import com.sicredi.avaliacao.dtos.SessaoDto;
import com.sicredi.avaliacao.dtos.SessaoForm;
import com.sicredi.avaliacao.services.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping(value = "/sessoes")
public class SessaoController {
    @Autowired
    SessaoService sessaoService;

    @PostMapping(value = "/iniciar/{idPauta}")
    public ResponseEntity<SessaoDto> iniciarSessao(@RequestBody @Valid SessaoForm form, @PathVariable(name = "idPauta")Long idPauta) {
        if (sessaoService.criarSessao(form, idPauta) != null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    @GetMapping
    public List<SessaoDto> imprimirTodasSessoes(){
        return ConversorSessao.converterParaSessaoDto((sessaoService.imprimirSessoes()));
    }
}
