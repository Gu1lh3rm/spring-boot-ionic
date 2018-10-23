package com.gml.cursomc.repositories;


import com.gml.cursomc.domain.ProdutoFile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoFileRepository extends JpaRepository<ProdutoFile, Integer> {

}