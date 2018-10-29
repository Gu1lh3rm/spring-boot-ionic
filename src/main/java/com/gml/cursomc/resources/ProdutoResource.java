package com.gml.cursomc.resources;


import com.gml.cursomc.domain.Categoria;
import com.gml.cursomc.domain.File;
import com.gml.cursomc.domain.Produto;
import com.gml.cursomc.domain.ProdutoFile;
import com.gml.cursomc.dto.FileNewDTO;
import com.gml.cursomc.dto.ProdutoDTO;
import com.gml.cursomc.dto.ProdutoFileNewDTO;
import com.gml.cursomc.dto.ProdutoNewDTO;
import com.gml.cursomc.resources.utils.URL;
import com.gml.cursomc.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api/produtos")
public class ProdutoResource {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
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
    public ProdutoFileNewDTO  insertFile(@Valid @RequestBody ProdutoFileNewDTO objDto){

        Produto produto = new Produto();

        produto = produtoService.findById(objDto.getProdutoId());



       /* ProdutoFile produtoFile = new ProdutoFile();

        produtoFile = produtoService.insertProdutoFile(objDto);*/

        /*

        produto = produtoService.findById(objDto.getProdutoId());*/

        /*objDto.getFile().forEach(o -> {
            *//*System.out.println("teste de insert");
            System.out.println(o.toString());*//*
            ProdutoFile produtoFile = new ProdutoFile(o, produto);

            produtoService.insertProdutoFile(produtoFile);

        });*/



        //produtoFileRepository.saveAll(Arrays.asList(produtoFile));

//
//
//        ProdutoFile produtoFile = new ProdutoFile(file, produto);

//        objDto.getFile().forEach(o -> {
//            System.out.println("teste de insert");
//            System.out.println(o.toString());
//        });


//        ProdutoFile obj = produtoService.fromDTO(objDto);


        //obj = produtoService.insertProdutoFile(obj);

        return null;

    }

}
