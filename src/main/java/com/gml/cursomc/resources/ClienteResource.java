package com.gml.cursomc.resources;

import com.gml.cursomc.domain.Cliente;
import com.gml.cursomc.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ClienteResource {
    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/clientes")
    public List<Cliente> getClientes(){
        return clienteService.findAll();
    }

    @GetMapping(value = "/clientes/{id}")
    public ResponseEntity<?> getCliente(@PathVariable Integer id){
        Cliente obj = clienteService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
