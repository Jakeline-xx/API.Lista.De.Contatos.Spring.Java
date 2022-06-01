package service.impl;

import domain.model.ContatoEntity;
import domain.model.UsuarioEntity;
import domain.repository.IContatoRepository;
import dto.ContatoDto;
import exception.ContatoNotFoundException;
import exception.UsuarioNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import service.IContatoService;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class ContatoService implements IContatoService {

    private final UsuarioService usuarioService;
    private final IContatoRepository repository;

    @Override
    public List<ContatoDto> obterListaDeContatosDoUsuario(final String nomeUsuario)  {

        //checkNotNull(nomeUsuario, "nome de usuario null");

        final UsuarioEntity usuarioEntity = usuarioService.encontrarUsuarioPeloNomeUsuario(nomeUsuario);

        return repository
                .obterTodosPorUsuarioEntityIgual(usuarioEntity)
                .stream()
                .map(contatoEntity -> new ContatoDto(contatoEntity.getId(), usuarioEntity.getNomeUsuario(), contatoEntity.getNome(), contatoEntity.getNumero()))
                .collect(Collectors.toList());
    }

    @Override
    public void deletarContatoDoUsuario(final String nomeUsuario, final long contatoId) throws UsuarioNotFoundException, ContatoNotFoundException {
        try {

            //checkNotNull(nomeUsuario);
            //checkArgument(contatoId > 0);

            usuarioService.encontrarUsuarioPeloNomeUsuario(nomeUsuario);

            final ContatoEntity contatoEntity = obterContatoPorId(contatoId);

            repository.delete(contatoEntity);

        } catch (UsuarioNotFoundException e) {
            log.error("Usuario nao encontrado: " + nomeUsuario);
            log.error(e.getMessage());
            throw e;
        } catch (ContatoNotFoundException e) {
            log.error("ContatoEntity nao encontrado: " + contatoId);
            log.error(e.getMessage());
            throw e;
        }
    }

    private ContatoEntity obterContatoPorId(final long contatoId) throws ContatoNotFoundException{

        //checkArgument(contatoId > 0);

        return repository
                .findById(contatoId)
                .orElseThrow(() -> new ContatoNotFoundException("ContatoEntity nao encontrado"));
    }

    @Override
    public void atualizarContato(final ContatoDto contatoDto) throws UsuarioNotFoundException{

        //checkNotNull(contatoDto);

        final UsuarioEntity usuarioEntity = usuarioService.encontrarUsuarioPeloNomeUsuario(contatoDto.getNomeUsuario());
        final ContatoEntity contatoEntity = ContatoEntity.builder()
                .id(contatoDto.getId())
                .usuarioEntity(usuarioEntity)
                .nome(contatoDto.getNome())
                .numero(contatoDto.getNumero())
                .build();
        repository.save(contatoEntity);

    }

    @Override
    public void salvarContato(final ContatoDto contatoDto) throws UsuarioNotFoundException{

        //checkNotNull(contatoDto);

        final UsuarioEntity usuarioEntity = usuarioService.encontrarUsuarioPeloNomeUsuario(contatoDto.getNomeUsuario());
        final ContatoEntity todoEntity = ContatoEntity.builder()
                .nome(contatoDto.getNome())
                .numero(contatoDto.getNumero())
                .usuarioEntity(usuarioEntity)
                .build();
        repository.save(todoEntity);
    }
}