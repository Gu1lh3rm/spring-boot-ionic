package com.gml.cursomc.services;

import com.gml.cursomc.domain.Categoria;
import com.gml.cursomc.exceptions.ObjectNotFoundException;
import com.gml.cursomc.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscar(Integer id_categoria){

    Optional<Categoria> obj = categoriaRepository.findById(id_categoria);

        return obj.orElseThrow(
                () -> new ObjectNotFoundException(
                        "Objeto não encontrado! Id: " + id_categoria + ", Tipo: " + Categoria.class.getName()
                )

        );
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
}
