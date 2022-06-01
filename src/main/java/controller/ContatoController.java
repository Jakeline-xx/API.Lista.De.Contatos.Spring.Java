package controller;

import dto.ContatoDto;
import exception.UsuarioNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import service.impl.ContatoService;

import java.util.List;

@RestController
@Log4j2
public class ContatoController {

    private final ContatoService service;

    @GetMapping(path="/{nomeUsuario}/buscar-lista-de-contatos")
    public ResponseEntity<ContatoDto> obterListaDeContatosPorUsuario(@PathVariable(name = "nomeUsuario") final String nomeUsuario)
            throws UsuarioNotFoundException {
        final List<ContatoDto> contatoDtoList =  service.obterListaDeContatosDoUsuario(nomeUsuario);

        return ResponseEntity.ok(contatoDtoList);
    }

//    @DeleteMapping(path="/users/{username}/todos/{todoId}")
//    public ResponseEntity<Void> deleteTodoFromUser(@PathVariable(name="username") final String username,
//                                                   @PathVariable(name="todoId") final long todoId)
//            throws UserNotFoundException, TodoNotFoundException {
//
//        service.deleteTodoFromUser(username, todoId);
//
//        return ResponseEntity.noContent().build();
//    }
//
//    @PutMapping(path="/todos")
//    public ResponseEntity<Void> updateTodo(@RequestBody final TodoDto todoDto) throws UserNotFoundException {
//
//        service.updateTodo(todoDto);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//    @PostMapping(path="/todos")
//    public ResponseEntity<Void> saveTodo(@RequestBody final TodoDto todoDto) throws UserNotFoundException {
//
//        service.saveTodo(todoDto);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
}