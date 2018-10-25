package com.gml.cursomc.dto;

import com.gml.cursomc.dto.common.BucketDTO;


public class ProdutoFileNewDTO extends BucketDTO{

    private Integer produtoId;

    public ProdutoFileNewDTO() {
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }
}
