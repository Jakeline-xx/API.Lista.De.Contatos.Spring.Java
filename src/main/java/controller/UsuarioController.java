package controller;


import dto.UsuarioDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.IUsuarioService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
public class UsuarioController {

    private final IUsuarioService service;

    @PostMapping(path="/usuario")
    public ResponseEntity<Void> salvarUsuario(@RequestBody UsuarioDto usuarioDto){

        service.salvarUsuario(usuarioDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path="/usuario")
    public ResponseEntity<List<UsuarioDto>> obterTodos() {

        List<UsuarioDto> contatoDtoList =  service.obterTodos();

        return ResponseEntity.ok(contatoDtoList);
    }

}