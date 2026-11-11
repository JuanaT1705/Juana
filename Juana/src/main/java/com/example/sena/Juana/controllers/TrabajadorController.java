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
import com.example.sena.Juana.dtos.TrabajadorDto;
import com.example.sena.Juana.dtos.TrabajadorDtoResponse;
import com.example.sena.Juana.services.TrabajadorServices;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping ("api/trabajador")
@RequiredArgsConstructor 
public class TrabajadorController {

    
    private final TrabajadorServices  trabajadorServices;
    
    
    //Registrar nuevo trabajador
    @PostMapping
    public ResponseEntity <TrabajadorDtoResponse> guardar (@Valid @RequestBody TrabajadorDto trabajadorDto) {
        TrabajadorDtoResponse trabajadorguardado = trabajadorServices.guardar(trabajadorDto);
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(trabajadorguardado);
    }

    //listar Trabajadores
    @GetMapping
    public ResponseEntity<List<TrabajadorDtoResponse>> ListarTodos() {
        return ResponseEntity.ok(trabajadorServices.listarTodos());
    }

    //Consultar trabajador por Id
    @GetMapping("/{id}")
    public ResponseEntity<TrabajadorDtoResponse> consultaId(@PathVariable Long id){
        return ResponseEntity.ok(trabajadorServices.buscarId(id));
    }

    //Actualizar trabajador
    @PutMapping("/{id}")
    public ResponseEntity<TrabajadorDtoResponse> update(@PathVariable Long id, @RequestBody TrabajadorDto trabajadorDto) {
        TrabajadorDtoResponse trabajadorActualizado = trabajadorServices.actualizar(id, trabajadorDto);
        return ResponseEntity.ok(trabajadorActualizado);
    }
    //actualizar trabajador
    @PutMapping("/actualizar")
    public ResponseEntity<TrabajadorDtoResponse> update(@RequestBody TrabajadorDto trabajadorDto) {
        TrabajadorDtoResponse trabajadorActualizado = trabajadorServices.actualizar(trabajadorDto.getId(), trabajadorDto);
        return ResponseEntity.ok(trabajadorActualizado);
    }
    //Eliminar trabajador
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id, @RequestBody TrabajadorDto trabajadorDto) {
        trabajadorServices.delete(id, trabajadorDto);
        return ResponseEntity.ok("Trabajador eliminado correctamente");
    }
    
}
