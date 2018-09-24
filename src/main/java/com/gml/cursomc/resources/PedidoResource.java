package com.gml.cursomc.resources;

import com.gml.cursomc.domain.Categoria;
import com.gml.cursomc.domain.Pedido;
import com.gml.cursomc.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class PedidoResource {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping(value = "/pedidos")
    public List<Pedido> getPedidos(){
        return pedidoService.findAll();
    }

    @GetMapping(value = "/pedidos/{id}")
    public ResponseEntity<Pedido> getPedido(@PathVariable Integer id) {
        Pedido obj = pedidoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/pedidos")
    public ResponseEntity<Void> insert(@Valid @RequestBody Pedido obj){
        obj = pedidoService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
