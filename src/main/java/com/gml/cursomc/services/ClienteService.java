package com.gml.cursomc.services;

import com.gml.cursomc.domain.Cidade;
import com.gml.cursomc.domain.Cliente;
import com.gml.cursomc.domain.Endereco;
import com.gml.cursomc.domain.enums.TipoCliente;
import com.gml.cursomc.dto.ClienteDTO;
import com.gml.cursomc.dto.ClienteNewDTO;
import com.gml.cursomc.repositories.CidadeRepository;
import com.gml.cursomc.repositories.EnderecoRepository;
import com.gml.cursomc.services.exceptions.DataIntegrityException;
import com.gml.cursomc.services.exceptions.ObjectNotFoundException;
import com.gml.cursomc.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! " + id + ", Tipo: " + Cliente.class.getName()
        ));
    }

    public Cliente insert(Cliente obj) {
        obj.setId(null);
        obj = clienteRepository.save(obj);
        enderecoRepository.saveAll(obj.getEnderecos());
        return obj;
    }

    public Cliente update(Cliente obj){
        Cliente newObj = findById(obj.getId());
        updateData(newObj, obj);
        return clienteRepository.save(newObj);
    }

    private void updateData(Cliente newObj, Cliente obj){
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }

    public void deleteById(Integer id){
        findById(id);
        try {
            clienteRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possível excluir um cliente que possua pedidos");
        }

    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return clienteRepository.findAll(pageRequest);
    }

    public Cliente fromDTO(ClienteDTO objDto){
        return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
    }

    public Cliente fromDTO(ClienteNewDTO objDto) {
        Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCfopOuCnpj(), TipoCliente.toEnum(objDto.getTipo()));

        Cidade cid = new Cidade(objDto.getCidadeId(), null, null);

        Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cli, cid);

        cli.getEnderecos().add(end);

        cli.getTelefones().add(objDto.getTelefone1());

        if (objDto.getTelefone2()!=null) cli.getTelefones().add(objDto.getTelefone2());

        if (objDto.getTelefone3()!=null) cli.getTelefones().add(objDto.getTelefone3());

        return cli;
    }

}
