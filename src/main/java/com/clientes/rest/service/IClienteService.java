package com.clientes.rest.service;

import com.clientes.rest.model.dto.ClienteDTO;
import com.clientes.rest.model.entity.Cliente;

import java.util.List;

public interface IClienteService {
    
    Cliente save (ClienteDTO clienteDto);
    List<Cliente> listAll();
    Cliente findById (Integer id);
    void dalete (Cliente cliente);
    boolean existById(Integer id);
}
