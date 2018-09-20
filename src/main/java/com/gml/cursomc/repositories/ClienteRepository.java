package com.gml.cursomc.repositories;

import com.gml.cursomc.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

    @Transactional
    Cliente findByEmail(String email);

    @Transactional
    Cliente findByCpfOuCnpj(String cpfOucnpj);

}
