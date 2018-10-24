package com.gml.cursomc.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ProdutoNewDTO implements Serializable {
    private static final long serialVersionUID =1L;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String nome;

    @NotNull(message = "Preenchimento obrigatório")
    private Double preco;

    @NotNull(message = "Preenchimento obrigatório")
    private Integer categoriaId;

    public ProdutoNewDTO() {
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

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProdutoNewDTO{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", preco=").append(preco);
        sb.append(", categoriaId=").append(categoriaId);
        sb.append('}');
        return sb.toString();
    }
}
