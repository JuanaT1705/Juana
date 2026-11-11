package com.example.sena.Juana.services;

import java.util.List;


import com.example.sena.Juana.dtos.TrabajadorDto;
import com.example.sena.Juana.dtos.TrabajadorDtoResponse;



public interface TrabajadorServices{

    //Registrar un nuevo usuario
    TrabajadorDtoResponse guardar(TrabajadorDto trabajadorDto);

    //Listar todos los usuarios

    List<TrabajadorDtoResponse> listarTodos();

     //Consultar por Id

    TrabajadorDtoResponse buscarId(Long id);

    //Actualizar un usuario
    TrabajadorDtoResponse actualizar(Long id, TrabajadorDto trabajadorDto);

    //Eliminar un usuario

    TrabajadorDtoResponse delete(Long id, TrabajadorDto trabajadorDto);


}
