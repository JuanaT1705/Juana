package com.example.sena.Juana.services;

import java.util.List;

import com.example.sena.Juana.dtos.ClienteDto;
import com.example.sena.Juana.dtos.ClienteDtoResponse;


public interface ClienteServices {

    //Registrar un nuevo usuario
    ClienteDtoResponse guardar(ClienteDto clienteDto);

    //Listar todos los usuarios

    List<ClienteDtoResponse> listarTodos();

    //Consultar por Id

    ClienteDtoResponse buscarId(Long id);

    //Actualizar un usuario
    ClienteDtoResponse actualizar(Long id, ClienteDto clienteDto);

    //Eliminar un usuario

    ClienteDtoResponse delete(Long id, ClienteDto clienteDto);


}
