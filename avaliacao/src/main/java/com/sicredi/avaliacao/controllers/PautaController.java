package com.sicredi.avaliacao.controllers;
import com.sicredi.avaliacao.dtos.PautaDto;
import com.sicredi.avaliacao.dtos.PautaForm;
import com.sicredi.avaliacao.models.Pauta;
import com.sicredi.avaliacao.Conversores.ConversorPauta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sicredi.avaliacao.services.PautaService;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
@RestController
@RequestMapping(value = "/pautas")
public class PautaController {
    @Autowired
    private PautaService pautaService;
    @PostMapping
    public ResponseEntity<PautaDto> cadastrarPauta(@RequestBody @Valid PautaForm form,UriComponentsBuilder uriBuilder) {

        Pauta pautaNova = pautaService.criarPauta(pautaService.convertePautaFormParaPauta(form));
        if (pautaNova != null) {
            URI uri = uriBuilder.path("/pautas/{id}").buildAndExpand(pautaNova.getId()).toUri();
            return ResponseEntity.created(uri).body(new PautaDto(pautaNova));
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
    @GetMapping
    public List<PautaDto> imprimirTodasPautas(){
        return ConversorPauta.converterPautaParaPautaDto(pautaService.imprimirPautas());
    }
    @GetMapping("/{id}")
    public ResponseEntity<PautaDto> buscarPautaPorId(@PathVariable(name = "id") long id){
     return ResponseEntity.ok(new PautaDto(pautaService.buscarPautaPorId(id)));
    }
}
