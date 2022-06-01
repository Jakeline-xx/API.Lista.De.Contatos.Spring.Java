package service.impl;

import domain.model.UsuarioEntity;
import domain.repository.IUsuarioRepository;
import dto.UsuarioDto;
import exception.UsuarioNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import service.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {

    private final IUsuarioRepository repository;

    public void salvarUsuario(UsuarioDto usuarioDto) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDto.getNomeUsuario(), usuarioDto.getNome());
        repository.save(usuarioEntity);
    }

    public List<UsuarioDto> obterTodos() {
        return
                repository
                        .findAll()
                        .stream()
                        .map(user -> new UsuarioDto(user.getNomeUsuario(), user.getNome()))
                        .collect(Collectors.toList());
    }

    public UsuarioEntity encontrarUsuarioPeloNomeUsuario(String usuario) throws UsuarioNotFoundException {
        return repository
                .findById(usuario)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario nao encontrado."));
    }
}