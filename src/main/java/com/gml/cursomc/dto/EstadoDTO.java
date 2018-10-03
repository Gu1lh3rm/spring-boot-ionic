package com.gml.cursomc.dto;

import com.gml.cursomc.domain.Estado;
import com.gml.cursomc.services.validation.ClienteUpdate;
import java.io.Serializable;

@ClienteUpdate
public class EstadoDTO implements Serializable {
    private static final long serialVersionUID =1L;

    private Integer id;
    private String nome;

    public EstadoDTO() {

    }

    public EstadoDTO(Estado obj) {
        id = obj.getId();
        nome = obj.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
