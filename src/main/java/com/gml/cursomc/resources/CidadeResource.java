package com.gml.cursomc.resources;

import com.gml.cursomc.domain.Cidade;
import com.gml.cursomc.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class CidadeResource {
    @Autowired
    private CidadeService cidadeService;

    @GetMapping(value = "/cidades")
    private List<Cidade> getCidades(){
        return cidadeService.findAll();
    }

    @GetMapping(value = "/cidades/{id}")
    public ResponseEntity<?> getCidade(@PathVariable Integer id){
        Cidade obj = cidadeService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
