package domain.repository;

import domain.model.ContatoEntity;
import domain.model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Long> {

//    List<ContatoRepository> findAllByUsuarioEntityEquals(UsuarioEntity user);

}
