package domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Builder
@Entity
@Table(name = "contato")
public class ContatoEntity {
    @Id
    @GeneratedValue
    private Long id;

//    @NotBlank(message="nome nao deve ficar vazio")     ADD: VALIDACAO
    private String nome;

//    @NotBlank(message="numero nao deve ficar vazio")     ADD: VALIDACAO
    private String numero;

    @ManyToOne(fetch = FetchType.LAZY)  //FetchType.EAGER
    private UsuarioEntity usuarioEntity;
}
