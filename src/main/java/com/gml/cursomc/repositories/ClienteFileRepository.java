package com.gml.cursomc.repositories;


import com.gml.cursomc.domain.ClienteFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ClienteFileRepository extends JpaRepository<ClienteFile, Integer>{

    @Transactional
    ClienteFile findByClienteId(Integer id);

}
