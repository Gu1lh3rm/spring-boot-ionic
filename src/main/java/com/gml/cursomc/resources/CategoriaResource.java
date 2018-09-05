package com.gml.cursomc.resources;

import com.gml.cursomc.domain.Categoria;
import com.gml.cursomc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class CategoriaResource {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/categorias")
    public List<Categoria> getCategorias() {
        return categoriaService.findAll();
    }

    @GetMapping(value = "/categorias/{id}")
    public ResponseEntity<?> getCategoria(@PathVariable Integer id) {
        Categoria obj = categoriaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
