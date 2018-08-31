package com.gml.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Cidade implements Serializable {
    private static final long seriaVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCidade;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_estado"
            , insertable = false
            , updatable = false
            , foreignKey = @ForeignKey(name = "fkey_cidade_estado")
    )


    private Estado estado;

    public Cidade() {

    }

    public Cidade(Integer idCidade, String nome, Estado estado) {
        this.idCidade = idCidade;
        this.nome = nome;
        this.estado = estado;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cidade)) return false;
        Cidade cidade = (Cidade) o;
        return Objects.equals(getIdCidade(), cidade.getIdCidade());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdCidade());
    }
}
