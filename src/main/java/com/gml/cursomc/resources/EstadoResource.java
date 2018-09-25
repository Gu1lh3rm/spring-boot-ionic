package com.gml.cursomc.resources;

import com.gml.cursomc.domain.Categoria;
import com.gml.cursomc.domain.Estado;
import com.gml.cursomc.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class EstadoResource {
    @Autowired
    private EstadoService estadoService;

    @GetMapping(value = "/estados")
    public List<Estado> getEstados(){
        return estadoService.findAll();
    }

    @GetMapping(value = "/estados/{id}")
    public ResponseEntity<?> getEstado(@PathVariable Integer id){
        Estado obj = estadoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
