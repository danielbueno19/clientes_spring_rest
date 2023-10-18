package com.clientes.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clientes.rest.model.entity.Cliente;
import com.clientes.rest.service.IClienteService;

@RestController
@RequestMapping("api/v1")
public class ClienteController {

    @Autowired
    private IClienteService iClienteService;

    @PostMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create (@RequestBody Cliente cliente){
        return iClienteService.save(cliente);
    }
    
    @PutMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update (@RequestBody Cliente cliente){
        return iClienteService.save(cliente);
    }

    @GetMapping("cliente/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente showById (@PathVariable Integer id){
        return iClienteService.findById(id);
    }

    @DeleteMapping("cliente/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void dalete (@PathVariable Integer id){
        Cliente cliente = iClienteService.findById(id);
        iClienteService.dalete(cliente);
    }
    
}
