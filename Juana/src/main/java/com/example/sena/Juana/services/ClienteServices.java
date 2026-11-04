package com.example.sena.Juana.services;

import java.util.List;

import com.example.sena.Juana.dtos.ClienteDto;


public interface ClienteServices {

    //Registrar un nuevo usuario
    ClienteDto guardar(ClienteDto clienteDto);

    //Listar todos los usuarios

    List<ClienteDto> listarTodos();

    //Consultar por Id

    ClienteDto buscarId(Long id);

    //Actualizar un usuario
    ClienteDto actualizar(Long id, ClienteDto clienteDto);

    //Eliminar un usuario

    ClienteDto delete(Long id, ClienteDto clienteDto);


}
