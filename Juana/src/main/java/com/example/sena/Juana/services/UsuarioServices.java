package com.example.sena.Juana.services;

import java.util.List;

import com.example.sena.Juana.dtos.UsuarioDto;

public interface UsuarioServices {
    
    //Registrar un nuevo usuario
    UsuarioDto guardar(UsuarioDto usuarioDto);

    //Listar todos los usuarios

    List<UsuarioDto> listarTodos();

    //Consultar por Id

    UsuarioDto buscarId(Long id);

    //Actualizar un usuario
    UsuarioDto actualizar(Long id, UsuarioDto usuarioDto);

    //Eliminar un usuario
    UsuarioDto deleteDto(Long id);

}
