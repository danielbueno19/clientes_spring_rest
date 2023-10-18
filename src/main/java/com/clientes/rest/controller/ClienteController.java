package com.clientes.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clientes.rest.model.dto.ClienteDTO;
import com.clientes.rest.model.entity.Cliente;
import com.clientes.rest.service.IClienteService;

import java.util.*;

@RestController
@RequestMapping("api/v1")
public class ClienteController {

    @Autowired
    private IClienteService iClienteService;

    @PostMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO create (@RequestBody ClienteDTO clienteDto){
        Cliente cliente = iClienteService.save(clienteDto);
        return ClienteDTO.builder()
                  .idCliente(cliente.getIdCliente())
                  .nombre(cliente.getNombre())
                  .apellido(cliente.getApellido())
                  .correo(cliente.getCorreo())
                  .fechaRegistro(cliente.getFechaRegistro())
                  .build();         
    }
    
    @PutMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO update (@RequestBody ClienteDTO clienteDto){
        Cliente cliente = iClienteService.save(clienteDto);
        return ClienteDTO.builder()
                  .idCliente(cliente.getIdCliente())
                  .nombre(cliente.getNombre())
                  .apellido(cliente.getApellido())
                  .correo(cliente.getCorreo())
                  .fechaRegistro(cliente.getFechaRegistro())
                  .build(); 
    }

    @GetMapping("cliente/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteDTO showById (@PathVariable Integer id){
        Cliente cliente = iClienteService.findById(id);
        return ClienteDTO.builder()
                  .idCliente(cliente.getIdCliente())
                  .nombre(cliente.getNombre())
                  .apellido(cliente.getApellido())
                  .correo(cliente.getCorreo())
                  .fechaRegistro(cliente.getFechaRegistro())
                  .build(); 
    }

    @DeleteMapping("cliente/{id}")
    public ResponseEntity<?> dalete (@PathVariable Integer id){
        Map<String, String> response = new HashMap<>();
        try {
            Cliente cliente = iClienteService.findById(id);
            iClienteService.dalete(cliente);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (DataAccessException e) {
            response.put("mesege", e.getMessage());
            response.put("cliente", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
