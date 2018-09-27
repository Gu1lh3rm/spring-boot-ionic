package com.gml.cursomc.resources;

import com.gml.cursomc.domain.Endereco;
import com.gml.cursomc.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class EnderecoResource {
    @Autowired
    private EnderecoService enderecoService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/enderecos")
    public List<Endereco> getEnderecos() {
        return enderecoService.findAll();
    }

    @GetMapping(value = "/enderecos/{id}")
    public ResponseEntity<?> getEndereco(@PathVariable Integer id) {
        Endereco obj = enderecoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
