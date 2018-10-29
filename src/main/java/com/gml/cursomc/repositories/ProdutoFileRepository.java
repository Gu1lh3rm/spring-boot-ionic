package com.gml.cursomc.repositories;


import com.gml.cursomc.domain.ProdutoFile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProdutoFileRepository extends JpaRepository<ProdutoFile, Integer> {
}