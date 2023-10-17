package com.clientes.rest.service;

import com.clientes.rest.model.entity.Cliente;

public interface IClienteService {
    
    Cliente save (Cliente cliente);
    Cliente findById (Integer id);
    void dalete (Cliente cliente);
}
