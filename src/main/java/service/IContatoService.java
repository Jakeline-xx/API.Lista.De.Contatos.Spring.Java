package service;

import dto.ContatoDto;
import dto.UsuarioDto;

import java.util.List;

public interface IContatoService {
    List<ContatoDto> obterListaDeContatosDoUsuario(String nomeUsuario);

    void deletarContatoDoUsuario(String nomeUsuario, long contatoId); //throws UserNotFoundException, TodoNotFoundException;

    void atualizarContato(ContatoDto contatoDto); //throws UserNotFoundException;

    void salvarContato(ContatoDto contatoDto); //throws UserNotFoundException;

    ContatoDto gerarContatoAleatorio(UsuarioDto usuarioDto);
}
