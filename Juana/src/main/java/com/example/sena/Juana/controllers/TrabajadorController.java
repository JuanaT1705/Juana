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

import com.example.sena.Juana.dtos.TrabajadorDto;
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
    public ResponseEntity <TrabajadorDto> guardar (@Valid @RequestBody TrabajadorDto trabajadorDto) {
        TrabajadorDto trabajadorguardado = trabajadorServices.guardar(trabajadorDto);
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(trabajadorguardado);
    }
    
    //listar Trabajadores
    @GetMapping
    public ResponseEntity<List<TrabajadorDto>> listarTodos() {
        return ResponseEntity.ok(trabajadorServices.listarTodos());
    }
    
    //Consultar trabajador por Id
    @GetMapping("/{id}")
    public ResponseEntity<TrabajadorDto> consultaId(@PathVariable Long id){
        return ResponseEntity.ok(trabajadorServices.buscarId(id));
    }

    //Consultar trabajador por Post
    @PostMapping("/buscar")
    public ResponseEntity<TrabajadorDto> consultarIdPost(@RequestBody TrabajadorDto dto){
        TrabajadorDto encontrado = trabajadorServices.buscarId(dto.getId());
        return ResponseEntity.ok(encontrado);
    }

    //Actualizar trabajador
    @PutMapping("/{id}")
    public ResponseEntity<TrabajadorDto> update(@PathVariable Long id, @RequestBody TrabajadorDto trabajadorDto) {
        TrabajadorDto trabajadorActualizado = trabajadorServices.actualizar(id, trabajadorDto);
        return ResponseEntity.ok(trabajadorActualizado);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<TrabajadorDto> update(@RequestBody TrabajadorDto trabajadorDto) {
        TrabajadorDto trabajadorActualizado = trabajadorServices.actualizar(trabajadorDto.getId(), trabajadorDto);
        return ResponseEntity.ok(trabajadorActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id, @RequestBody TrabajadorDto trabajadorDto) {
        trabajadorServices.delete(id,null);
        return ResponseEntity.ok("Trabajador eliminado correctamente");
    }

}
