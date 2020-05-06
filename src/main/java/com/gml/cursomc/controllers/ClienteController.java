package com.gml.cursomc.controllers;

import com.gml.cursomc.domain.Cliente;
import com.gml.cursomc.domain.ClienteFile;
import com.gml.cursomc.dto.ClienteDTO;
import com.gml.cursomc.dto.ClienteNewDTO;
import com.gml.cursomc.services.ClienteService;
import com.gml.cursomc.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EmailService emailService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Integer id) {
        Cliente obj = clienteService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/email")
    public ResponseEntity<Cliente> getEmail(@RequestParam(value = "value") String email) {
        Cliente obj = clienteService.findByEmail(email);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ClienteNewDTO objDto){
        Cliente obj = clienteService.fromDTO(objDto);
        obj = clienteService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO objDto, @PathVariable Integer id){
        Cliente obj = clienteService.fromDTO(objDto);
        obj.setId(id);
        obj = clienteService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getClientes() {
        List<Cliente> list = clienteService.findAll();
        List<ClienteDTO> listDto = list.stream().map( obj -> new ClienteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/password")
    public ResponseEntity<Cliente> getEmailTest(@RequestParam(value = "value") String email) {
        Cliente obj = clienteService.findByEmail(email);
        return ResponseEntity.ok().body(obj);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/page")
    public ResponseEntity<Page<ClienteDTO>> getFindPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerpage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Cliente> list = clienteService.findPage(page, linesPerPage, orderBy, direction);
        Page<ClienteDTO> listDto = list.map( obj -> new ClienteDTO(obj));
        return ResponseEntity.ok().body(listDto);
    }

//    @RequestMapping(value="/picture", method=RequestMethod.POST)
//    public ResponseEntity<Void> uploadProfilePicture(@RequestParam(name="file") MultipartFile file) {
//        System.out.println(file);
//        return null;
//    }

    @PostMapping(value = "/picture")
    public ResponseEntity<Void> insertFile(@Valid @RequestBody ClienteFile obj){
        //ClienteFile obj = clienteService.fromDTO(objDto);
        System.out.println(obj.toString());
        obj = clienteService.insertFile(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
