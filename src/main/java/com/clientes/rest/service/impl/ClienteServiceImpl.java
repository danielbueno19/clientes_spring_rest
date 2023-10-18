package com.clientes.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clientes.rest.model.dao.ClienteDAO;
import com.clientes.rest.model.dto.ClienteDTO;
import com.clientes.rest.model.entity.Cliente;
import com.clientes.rest.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private ClienteDAO clienteDao;

    @Transactional
    @Override
    public Cliente save(ClienteDTO clienteDto) {
        Cliente cliente = Cliente.builder()
                                 .idCliente(clienteDto.getIdCliente())
                                 .nombre(clienteDto.getNombre())
                                 .apellido(clienteDto.getApellido())
                                 .correo(clienteDto.getCorreo())
                                 .fechaRegistro(clienteDto.getFechaRegistro())
                                 .build();
        return clienteDao.save(cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public Cliente findById(Integer id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void dalete(Cliente cliente) {         
        clienteDao.delete(cliente);
    }
    
}
