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
import org.springframework.web.bind.annotation.RestController;

import com.clientes.rest.model.dto.ClienteDTO;
import com.clientes.rest.model.entity.Cliente;
import com.clientes.rest.model.payload.MensajeResponse;
import com.clientes.rest.service.IClienteService;

@RestController
@RequestMapping("api/v1")
public class ClienteController {

    @Autowired
    private IClienteService iClienteService;

    @PostMapping("/cliente")
    public ResponseEntity<?> create (@RequestBody ClienteDTO clienteDto){
        Cliente clienteSave = null;
        try {
            clienteSave= iClienteService.save(clienteDto);
            clienteDto = ClienteDTO.builder()
                             .idCliente(clienteSave.getIdCliente())
                             .nombre(clienteSave.getNombre())
                             .apellido(clienteSave.getApellido())
                             .correo(clienteSave.getCorreo())
                             .fechaRegistro(clienteSave.getFechaRegistro())
                             .build();

            return new ResponseEntity<>(MensajeResponse.builder()
                                                        .mensaje("Guardado Correcamente!!!")
                                                        .object(clienteDto)
                                                        .build()
                                  , HttpStatus.CREATED);
            
        } catch (DataAccessException e) {
            return new ResponseEntity<>(MensajeResponse.builder()
            .mensaje(e.getMessage())
            .object(null)
            .build(), HttpStatus.METHOD_NOT_ALLOWED);            
        }
                 
    }
    
    @PutMapping("/cliente/{id}")
    public ResponseEntity<?> update (@RequestBody ClienteDTO clienteDto,@PathVariable Integer id){
        Cliente clienteUpdate = null;
        try {
            if(iClienteService.existById(id)){    
                clienteDto.setIdCliente(id);        
                clienteUpdate= iClienteService.save(clienteDto);
                clienteDto = ClienteDTO.builder()
                                .idCliente(clienteUpdate.getIdCliente())
                                .nombre(clienteUpdate.getNombre())
                                .apellido(clienteUpdate.getApellido())
                                .correo(clienteUpdate.getCorreo())
                                .fechaRegistro(clienteUpdate.getFechaRegistro())
                                .build();

                return new ResponseEntity<>(MensajeResponse.builder()
                                                            .mensaje("Guardado Correcamente!!!")
                                                            .object(clienteDto)
                                                            .build()
                                    , HttpStatus.CREATED);
            }

            return new ResponseEntity<>(MensajeResponse.builder()
            .mensaje("El elemento que desea actualizar no existe!!!")
            .object(null)
            .build(), HttpStatus.METHOD_NOT_ALLOWED);

        } catch (DataAccessException e) {
            return new ResponseEntity<>(MensajeResponse.builder()
            .mensaje(e.getMessage())
            .object(null)
            .build(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("cliente/{id}")
    public ResponseEntity<?> showById (@PathVariable Integer id){
        Cliente cliente = iClienteService.findById(id);

        if(cliente != null){
            
            return new ResponseEntity<>(MensajeResponse.builder()
            .mensaje("")
            .object(ClienteDTO.builder()
                  .idCliente(cliente.getIdCliente())
                  .nombre(cliente.getNombre())
                  .apellido(cliente.getApellido())
                  .correo(cliente.getCorreo())
                  .fechaRegistro(cliente.getFechaRegistro())
                  .build())
            .build(), HttpStatus.OK);
        }

        return new ResponseEntity<>(MensajeResponse.builder()
            .mensaje("El registro que intenta buscar no exite")
            .object(null)
            .build(), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("cliente/{id}")
    public ResponseEntity<?> dalete (@PathVariable Integer id){
        
        try {
            Cliente cliente = iClienteService.findById(id);
            iClienteService.dalete(cliente);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (DataAccessException e) {
            
            return new ResponseEntity<>(MensajeResponse.builder()
            .mensaje(e.getMessage())
            .object(null)
            .build(), HttpStatus.NOT_FOUND);
        }
    }
    
}
