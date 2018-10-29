package com.gml.cursomc.services;

import com.gml.cursomc.domain.Categoria;
import com.gml.cursomc.domain.Produto;
import com.gml.cursomc.dto.ProdutoFileNewDTO;
import com.gml.cursomc.dto.ProdutoNewDTO;
import com.gml.cursomc.repositories.CategoriaRepository;
import com.gml.cursomc.services.exceptions.ObjectNotFoundException;
import com.gml.cursomc.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;


    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(Integer id) {
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()
        ));
    }

    public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        List<Categoria> categorias = categoriaRepository.findAllById(ids);
        return produtoRepository.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
    }


    public Produto insert(Produto obj) {
        obj = produtoRepository.save(obj);
        return obj;
    }

    public Produto fromDTO(ProdutoNewDTO objDto) {

        Produto prod = new Produto(null, objDto.getNome(), objDto.getPreco());
        Categoria cat = new Categoria(objDto.getCategoriaId(), null, null);

        prod.getCategorias().add(cat);

        return prod;
    }

}
