package com.gml.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ProdutoFile implements Serializable {
    private static final long serialVersionUID =1L;

    @EmbeddedId
    private ProdutoFilePK id = new ProdutoFilePK();

    public ProdutoFile() {
    }

    public ProdutoFile(File file, Produto produto) {
        super();
        id.setFile(file);
        id.setProduto(produto);
    }

    public File getFile() {
        return id.getFile();
    }

    public Produto getProduto() {
        return id.getProduto();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProdutoFile)) return false;
        ProdutoFile that = (ProdutoFile) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
