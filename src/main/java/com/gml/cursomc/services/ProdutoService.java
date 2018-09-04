package com.gml.cursomc.services;

import com.gml.cursomc.domain.Produto;
import com.gml.cursomc.repositories.CategoriaRepository;
import com.gml.cursomc.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }
}
