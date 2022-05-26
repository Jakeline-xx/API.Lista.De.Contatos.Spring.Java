package domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;   MEXER NISSO QUANDO FOR FAZER VALIDACAO
//import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="usuario")
public class UsuarioEntity {

    @Id
    private String nomeUsuario;

//    @NotBlank(message="nome nao deve ficar vazio")          MEXER NISSO QUANDO FOR FAZER VALIDACAO
//    @Size(min = 3)
    private String nome;

}