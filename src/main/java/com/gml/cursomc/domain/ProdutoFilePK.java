package com.gml.cursomc.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProdutoFilePK implements Serializable {
    private static final long serialVersionUID =1L;

    @ManyToOne
    @JoinColumn(name = "file_id")
    private File file;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProdutoFilePK)) return false;
        ProdutoFilePK that = (ProdutoFilePK) o;
        return Objects.equals(getFile(), that.getFile()) &&
                Objects.equals(getProduto(), that.getProduto());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFile(), getProduto());
    }
}
