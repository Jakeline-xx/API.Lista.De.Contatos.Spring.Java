package com.apicrud.controller;

import com.apicrud.dto.ContatoDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class ContatoController {

    @GetMapping(path="/{id}/buscarcontato")
    public ResponseEntity<ContatoDto> obterContatoPorId(@PathVariable(name = "id") String id) {

    }
}
