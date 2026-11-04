package com.example.sena.Juana.services;

import java.util.List;

import com.example.sena.Juana.dtos.TrabajadorDto;



public interface TrabajadorServices {

    //Registrar un nuevo usuario
    TrabajadorDto guardar(TrabajadorDto trabajadorDto);

    //Listar todos los usuarios

    List<TrabajadorDto> listarTodos();

    //Consultar por Id

    TrabajadorDto   buscarId(Long id);

    //Actualizar un usuario
    TrabajadorDto actualizar(Long id, TrabajadorDto trabajadorDto);

    TrabajadorDto delete(Long id, TrabajadorDto trabajadorDto);

}
