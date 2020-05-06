package com.gml.cursomc.dto;

import com.gml.cursomc.domain.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID =1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 e 80 caracteres")
    private String nome;

    private String imgUrl;


    public CategoriaDTO(Categoria obj) {
        id = obj.getId();
        nome = obj.getNome();
        imgUrl = obj.getImgUrl();
    }

}
