package com.gml.cursomc.services;

import com.gml.cursomc.domain.Categoria;
import com.gml.cursomc.dto.CategoriaDTO;
import com.gml.cursomc.dto.bucketDTO;
import com.gml.cursomc.services.exceptions.DataIntegrityException;
import com.gml.cursomc.services.exceptions.ObjectNotFoundException;
import com.gml.cursomc.repositories.CategoriaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    private static final Logger LOG = (Logger) LoggerFactory.getLogger(CategoriaService.class);


    public List<Categoria> findAll() {
        List<Categoria> obj = categoriaRepository.findAll();
        return obj;
    }

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria insert(Categoria obj) {
        obj.setId(null);
        LOG.info("Teste de Log");
        LOG.info(obj.toString());
        return categoriaRepository.save(obj);
    }

    public Categoria update(Categoria obj){
        Categoria newObj = findById(obj.getId());
        updateData(newObj, obj);
        return categoriaRepository.save(newObj);
    }

    private void updateData(Categoria newObj, Categoria obj){
        newObj.setNome(obj.getNome());
        newObj.setImgUrl(obj.getImgUrl());
    }

    public void deleteById(Integer id){
        findById(id);
        try {
            categoriaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
        }

    }

    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return categoriaRepository.findAll(pageRequest);
    }

    public Categoria fromDTO(CategoriaDTO objDto){
        return new Categoria(objDto.getId(), objDto.getNome(), objDto.getImgUrl());
    }

}
