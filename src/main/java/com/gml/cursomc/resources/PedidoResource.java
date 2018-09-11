package com.gml.cursomc.resources;

import com.gml.cursomc.domain.Pedido;
import com.gml.cursomc.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
