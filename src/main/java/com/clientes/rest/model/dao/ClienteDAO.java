package com.clientes.rest.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.clientes.rest.model.entity.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Integer>{

    
    
}
