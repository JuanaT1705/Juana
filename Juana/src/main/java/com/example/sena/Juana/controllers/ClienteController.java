package com.example.sena.Juana.controllers;

import java.util.List;

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

import com.example.sena.Juana.dtos.ClienteDto;
import com.example.sena.Juana.dtos.ClienteDtoResponse;
import com.example.sena.Juana.servicesImplement.ClienteServicesImplement;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("api/clientes")
@RequiredArgsConstructor 
public class ClienteController {


    private final ClienteServicesImplement clienteServices;
    
    //Registrar nuevo cliente
    @PostMapping
    public ResponseEntity <ClienteDtoResponse> Guardar (@Valid @RequestBody ClienteDto clienteDto) {
        ClienteDtoResponse clienteguardado = clienteServices.guardar(clienteDto);
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(clienteguardado);
    }
    
    //listar Clientes
    @GetMapping
    public ResponseEntity<List<ClienteDtoResponse>> ListarTodos() {
        return ResponseEntity.ok(clienteServices.listarTodos());
    }
    
    //Consultar cliente por Id
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDtoResponse> consultaId(@PathVariable Long id){
        return ResponseEntity.ok(clienteServices.buscarId(id));
    }

    //Consultar cliente por Post
    @PostMapping("/buscar")
    public ResponseEntity<ClienteDtoResponse> consultarIdPost(@RequestBody ClienteDto dto){
        ClienteDtoResponse encontrado = clienteServices.buscarId(dto.getId());
        return ResponseEntity.ok(encontrado);
    }

   //Actualizar cliente
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDtoResponse> update(@PathVariable Long id, @RequestBody ClienteDto clienteDto) {
        ClienteDtoResponse clienteActualizado = clienteServices.actualizar(id, clienteDto);
        return ResponseEntity.ok(clienteActualizado);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<ClienteDtoResponse> update(@RequestBody ClienteDto clienteDto) {
        ClienteDtoResponse clienteActualizado = clienteServices.actualizar(clienteDto.getId(), clienteDto);
        return ResponseEntity.ok(clienteActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id, @RequestBody ClienteDto clienteDto) {
        clienteServices.delete(id, clienteDto);
        return ResponseEntity.ok("Cliente eliminado correctamente");
    }
}
