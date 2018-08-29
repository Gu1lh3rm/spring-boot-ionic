package com.gml.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Produto implements Serializable {
    private static final long seriaVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_produto;
    private String nome;
    private Double preco;

    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name = "PRODUTO_CATEGORIA",
            joinColumns = @JoinColumn(name = "produto_id", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "fkey_produto_categoria")),
            inverseJoinColumns = @JoinColumn(name = "categoria_id", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "fkey_categoria_produto"))
    )


    private List<Categoria> categorias = new ArrayList<>();

    public Produto() {

    }

    public Produto(Integer id_produto, String nome, Double preco) {
        this.id_produto = id_produto;
        this.nome = nome;
        this.preco = preco;
    }

    public Integer getId_produto() {
        return id_produto;
    }

    public void setId_produto(Integer id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return Objects.equals(getId_produto(), produto.getId_produto());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId_produto());
    }


}
