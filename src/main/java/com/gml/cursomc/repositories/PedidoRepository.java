package com.gml.cursomc.repositories;

import com.gml.cursomc.domain.Cliente;
import com.gml.cursomc.domain.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

    @Transactional
    Page<Pedido> findByCliente(Cliente cliente, Pageable pegeRequest);

}
