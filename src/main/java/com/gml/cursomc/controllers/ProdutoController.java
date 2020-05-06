package com.gml.cursomc.controllers;


import com.gml.cursomc.domain.File;
import com.gml.cursomc.domain.Produto;
import com.gml.cursomc.dto.ProdutoDTO;
import com.gml.cursomc.dto.ProdutoFileNewDTO;
import com.gml.cursomc.dto.ProdutoNewDTO;
import com.gml.cursomc.repositories.FileRepository;
import com.gml.cursomc.repositories.ProdutoRepository;
import com.gml.cursomc.controllers.utils.URL;
import com.gml.cursomc.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.*;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private FileRepository fileRepository;

    @GetMapping(value = "")
    public List<Produto> getProdutos() {
        return produtoService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> getProduto(@PathVariable Integer id){
        Produto obj = produtoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<ProdutoDTO>> findPage(
            @RequestParam(value="nome", defaultValue="") String nome,
            @RequestParam(value="categorias", defaultValue="") String categorias,
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="nome") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction) {
        String nomeDecoded = URL.decodeParam(nome);
        List<Integer> ids = URL.decodeIntList(categorias);
        Page<Produto> list = produtoService.search(nomeDecoded, ids, page, linesPerPage, orderBy, direction);
        Page<ProdutoDTO> listDto = list.map(obj -> new ProdutoDTO(obj));
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ProdutoNewDTO objDto){
        Produto obj = produtoService.fromDTO(objDto);

        obj = produtoService.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PostMapping(value = "/picture")
    public Produto insertFile(@Valid @RequestBody ProdutoFileNewDTO objDto){

        Produto produto = produtoService.findById(objDto.getProdutoId());

        Vector a = new Vector();

        produto.getFiles().forEach(o -> {
            a.add(o.getId());
        });

        produto.getFiles().removeAll(produto.getFiles());

        produtoRepository.save(produto);

        for ( Object o : a ) {

            if ((Integer) o != 1) {
                System.out.println(o.toString());
                fileRepository.deleteById((Integer) o);
            }
        }


        objDto.getFiles().forEach(obj -> {

            File file = produtoService.fromDTO(obj, produto);

            file = produtoService.insertFile(file);

            produto.getFiles().add(file);

            produtoRepository.save(produto);

        });


        Produto retProduto = produtoService.findById(objDto.getProdutoId());

        return retProduto;

    }

}
