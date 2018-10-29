package com.gml.cursomc.dto;

import com.gml.cursomc.domain.File;
import com.gml.cursomc.domain.ProdutoFile;
import com.gml.cursomc.dto.common.BucketDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ProdutoFileNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer produtoId;

    private List<BucketDTO> file;

    public ProdutoFileNewDTO() {
    }

    public ProdutoFileNewDTO(Integer produtoId, List<BucketDTO> file) {
        this.produtoId = produtoId;
        this.file = file;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public List<BucketDTO> getFile() {
        return file;
    }

    public void setFile(List<BucketDTO> file) {
        this.file = file;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProdutoFileNewDTO{");
        sb.append("produtoId=").append(produtoId);
        sb.append(", file=").append(file);
        sb.append('}');
        return sb.toString();
    }

}
