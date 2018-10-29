package com.gml.cursomc.repositories;

import com.gml.cursomc.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<File, Integer> {

    @Transactional
    List<File> findByHash(String hash);
}