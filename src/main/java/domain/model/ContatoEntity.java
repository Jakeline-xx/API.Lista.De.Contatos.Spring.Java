package domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "contato")
public class ContatoEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    private String numero;

    @ManyToOne(fetch = FetchType.LAZY)  //FetchType.EAGER
    private UsuarioEntity usuarioEntity;
}
