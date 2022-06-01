package service.impl;

import domain.model.UsuarioEntity;
import domain.repository.IContatoRepository;
import dto.ContatoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import service.IContatoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class ContatoService implements IContatoService {

    private final UsuarioService userService;
    private final IContatoRepository repository;
    private final RestTemplate restTemplate;

    @Override
    public List<ContatoDto> obterListaDeContatosDoUsuario(final String nomeUsuario)  {

        //checkNotNull(nomeUsuario, "username null");

        final UsuarioEntity usuarioEntity = userService.encontrarUsuarioPeloNomeUsuario(nomeUsuario);

        return repository
                .obterTodosPorUsuarioEntityIgual(usuarioEntity)
                .stream()
                .map(contatoEntity -> new ContatoDto(contatoEntity.getId(), usuarioEntity.getNomeUsuario(), contatoEntity.getNome(), contatoEntity.getNumero()))
                .collect(Collectors.toList());
    }

//    @Override
//    public void deleteTodoFromUser(final String username, final long todoId)
//            throws UserNotFoundException, TodoNotFoundException {
//        try {
//
//            checkNotNull(username);
//            checkArgument(todoId > 0);
//
//            userService.findUserByUsername(username);
//
//            final TodoEntity todoEntity = findTodoById(todoId);
//
//            repository.delete(todoEntity);
//
//        } catch (UserNotFoundException e) {
//            log.error("Usuario nao encontrado: " + username);
//            log.error(e.getMessage());
//            throw e;
//        } catch (TodoNotFoundException e) {
//            log.error("TodoEntity nao encontrado: " + todoId);
//            log.error(e.getMessage());
//            throw e;
//        }
//    }
//
//    private TodoEntity findTodoById(final long todoId) throws TodoNotFoundException {
//
//        checkArgument(todoId > 0);
//
//        return repository
//                .findById(todoId)
//                .orElseThrow(() -> new TodoNotFoundException("TodoEntity nao encontrado"));
//    }
//
//    @Override
//    public void updateTodo(final TodoDto todoDto) throws UserNotFoundException {
//
//        checkNotNull(todoDto);
//
//        final UserEntity userEntity = userService.findUserByUsername(todoDto.getUsername());
//        final TodoEntity todoEntity = TodoEntity.builder()
//                .id(todoDto.getId())
//                .description(todoDto.getDescription())
//                .userEntity(userEntity)
//                .build();
//        repository.save(todoEntity);
//
//    }
//
//    @Override
//    public void saveTodo(final TodoDto todoDto) throws UserNotFoundException {
//
//        checkNotNull(todoDto);
//
//        final UserEntity userEntity = userService.findUserByUsername(todoDto.getUsername());
//        final TodoEntity todoEntity = TodoEntity.builder()
//                .description(todoDto.getDescription())
//                .userEntity(userEntity)
//                .build();
//        repository.save(todoEntity);
//    }
//
//    @Override
//    public TodoDto generateRandomTodo(final UserDto userDto) {
//
//        checkNotNull(userDto);
//
//        final ResponseBoredDto responseBoredApi = getActivityFromBoredAPI();
//
//        UserEntity userEntity = userService.findUserByUsername(userDto.getUsername());
//
//        final TodoEntity entity = transformToTodoEntity(responseBoredApi, userEntity);
//
//        repository.save(entity);
//
//        final TodoDto dto = transformToDto(entity);
//
//        return  dto;
//    }
//
//    private TodoDto transformToDto(final TodoEntity entity) {
//        return
//                TodoDto.builder()
//                        .id(entity.getId())
//                        .description(entity.getDescription())
//                        .username(entity.getUserEntity().getUsername())
//                        .build();
//    }
//
//    private TodoEntity transformToTodoEntity(final ResponseBoredDto responseBoredApi, final UserEntity userEntity) {
//        return
//                TodoEntity.builder()
//                        .description(responseBoredApi.getDescription())
//                        .userEntity(userEntity)
//                        .build();
//    }
//
//    private ResponseBoredDto getActivityFromBoredAPI() {
//        return restTemplate
//                .getForEntity("https://www.boredapi.com/api/activity", ResponseBoredDto.class)
//                .getBody();
//    }

}