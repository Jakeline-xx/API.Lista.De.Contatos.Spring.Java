package service;

import domain.model.UsuarioEntity;
import dto.UsuarioDto;

import java.util.List;

public interface IUsuarioService {
    UsuarioEntity encontrarUsuarioPeloNomeUsuario(String nomeUsuario); //throws UserNotFoundException; //ADD: IMPLEMENTACAO DA EXCEPTION

    void salvarUsuario(UsuarioDto usuarioDto);

    List<UsuarioDto> obterTodos();
}
