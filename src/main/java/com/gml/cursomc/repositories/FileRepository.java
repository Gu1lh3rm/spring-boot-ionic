package com.gml.cursomc.repositories;

import com.gml.cursomc.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface FileRepository extends JpaRepository<File, Integer> {

//    @Transactional
//    @Query("DELETE FROM File obj WHERE obj.id = :id")
//    public void deleteByFileId(@Param("id") Integer id);
}