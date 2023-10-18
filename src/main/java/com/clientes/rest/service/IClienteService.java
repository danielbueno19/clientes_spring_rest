package com.clientes.rest.service;

import com.clientes.rest.model.dto.ClienteDTO;
import com.clientes.rest.model.entity.Cliente;

public interface IClienteService {
    
    Cliente save (ClienteDTO clienteDto);
    Cliente findById (Integer id);
    void dalete (Cliente cliente);
}
