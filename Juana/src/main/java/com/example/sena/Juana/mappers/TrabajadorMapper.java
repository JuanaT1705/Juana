package com.example.sena.Juana.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.sena.Juana.dtos.TrabajadorDto;
import com.example.sena.Juana.models.usuarios.Trabajador;

@Mapper (componentModel = "spring")
public interface TrabajadorMapper {

        //convertir de Entidad a Dto
    @Mapping(source = "nomb", target = "nom")
    @Mapping(source = "apell", target = "ape")
    @Mapping(source = "direc", target = "dir")
    @Mapping(source = "tele", target = "tel")
    Trabajador toEntidad(TrabajadorDto trabajadorDto);

      //convertir de Dto a Entidad
    @Mapping(source = "nom", target = "nomb")
    @Mapping(source = "ape", target = "apell")
    @Mapping(source = "dir", target = "direc")
    @Mapping(source = "tel", target = "tele")
    TrabajadorDto toDto(Trabajador trabajador);



}