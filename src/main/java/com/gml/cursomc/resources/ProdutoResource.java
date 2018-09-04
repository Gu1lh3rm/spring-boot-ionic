package com.gml.cursomc.resources;

import com.gml.cursomc.domain.Produto;
import com.gml.cursomc.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProdutoResource {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "/produtos")
    public List<Produto> getProduto() {
        return produtoService.findAll();
    }
}
