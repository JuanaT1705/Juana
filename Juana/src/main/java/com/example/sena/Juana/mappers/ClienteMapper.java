package com.example.sena.Juana.mappers;

import com.example.sena.Juana.dtos.ClienteDto;
import com.example.sena.Juana.models.usuarios.Cliente;

public interface ClienteMapper {

    //de Cliente a ClienteDto
    ClienteDto toDto(Cliente cliente);

    //de ClienteDto a Cliente
    Cliente toEntidad(ClienteDto clienteDto);

   
}
