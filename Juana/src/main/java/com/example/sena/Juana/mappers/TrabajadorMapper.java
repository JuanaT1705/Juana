package com.example.sena.Juana.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.sena.Juana.dtos.TrabajadorDto;
import com.example.sena.Juana.dtos.TrabajadorDtoResponse;
import com.example.sena.Juana.models.usuarios.Trabajador;

@Mapper (componentModel = "spring")
public interface TrabajadorMapper {

    // 1. Convertir de Entidad a DTo
    @Mapping(source = "nomb", target = "nom")
    @Mapping(source = "apell", target = "ape")
    @Mapping(source = "direc", target = "dir")
    @Mapping(source = "tele", target = "tel")
    @Mapping(source = "sueldo", target = "sueldo")
    @Mapping(target = "cargo", ignore = true) 
    Trabajador toEntidad(TrabajadorDto trabajadorDto);
    
    // 2. Convertir de Dto a Entidad (Fíjate que aquí va al revés)
    @Mapping(source = "nom", target = "nomb")
    @Mapping(source = "ape", target = "apell")
    @Mapping(source = "dir", target = "direc")
    @Mapping(source = "tel", target = "tele")
    @Mapping(source = "cargo.nom_TipoTrab", target = "cargo")
    TrabajadorDtoResponse toDtoResponse(Trabajador trabajador);
}