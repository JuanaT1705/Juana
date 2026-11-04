package com.example.sena.Juana.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sena.Juana.dtos.UsuarioDto;
import com.example.sena.Juana.services.UsuarioServices;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;





@RestController 
@RequestMapping("api/usuarios")
@RequiredArgsConstructor 
public class UsuarioController {

    private final UsuarioServices usuarioServices;
    
    //Registrar nuevo usuario
    @PostMapping
    public ResponseEntity <UsuarioDto> Guardar (@Valid @RequestBody UsuarioDto usuarioDto) {
        UsuarioDto usuarioguardado = usuarioServices.guardar(usuarioDto);
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(usuarioguardado);
    }
    
    //listar Usuarios
    @GetMapping
    public ResponseEntity<List<UsuarioDto>> ListarTodos() {
        return ResponseEntity.ok(usuarioServices.listarTodos());
    }
    
    //Consultar usuario por Id
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> consultaId(@PathVariable Long id){
        return ResponseEntity.ok(usuarioServices.buscarId(id));
    }

    //Consultar usuario por Post
    @PostMapping("/buscar")
    public ResponseEntity<UsuarioDto> consultarIdPost(@RequestBody UsuarioDto dto){
        UsuarioDto encontrado = usuarioServices.buscarId(dto.getId());
        return ResponseEntity.ok(encontrado);
    }

    //Actualizar usuario
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> update(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto) {
        UsuarioDto usuarioActualizado = usuarioServices.actualizar(id, usuarioDto);
        return ResponseEntity.ok(usuarioActualizado);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<UsuarioDto> update(@RequestBody UsuarioDto usuarioDto) {
        UsuarioDto usuarioActualizado = usuarioServices.actualizar(usuarioDto.getId(), usuarioDto);
        return ResponseEntity.ok(usuarioActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        usuarioServices.deleteDto(id);
        return ResponseEntity.ok("Usuario eliminado correctamente");
    }
}
