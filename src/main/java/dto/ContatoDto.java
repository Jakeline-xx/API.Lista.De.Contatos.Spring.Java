package dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContatoDto {

    private Long id;

    //@NotBlank

    private String nomeUsuario;

    //@NotBlank
    private String nome;
    private String numero;


    @JsonCreator
    public ContatoDto(@JsonProperty final Long id,
                   @JsonProperty(value = "nomeUsuario", required = true) final String nomeUsuario,
                   @JsonProperty final String nome,
                    @JsonProperty final String numero){
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.nome = nome;
        this.numero = numero;
    }
}
