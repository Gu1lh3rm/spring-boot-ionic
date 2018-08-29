package com.gml.cursomc.domain;

import java.io.Serializable;
import java.util.Objects;

public class Categoria implements Serializable{
    private static final long seriaVersionUID = 1L;
    private Integer id_categoria;
    private String nome;

    public Categoria() {

    }

    public Categoria(Integer id_categoria, String nome) {
        this.id_categoria = id_categoria;
        this.nome = nome;
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categoria)) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(getId_categoria(), categoria.getId_categoria());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId_categoria());
    }



}
