package com.gml.cursomc.controllers;

import com.gml.cursomc.domain.Pagamento;
import com.gml.cursomc.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pagamentos")
public class PagamentoController {
    @Autowired
    PagamentoService pagamentoService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public List<Pagamento> getPagamentos(){
        return pagamentoService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getPagamento(@PathVariable Integer id){
        Pagamento obj = pagamentoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
