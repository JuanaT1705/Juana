package com.example.sena.Juana.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.example.sena.Juana.dtos.UsuarioDto;
import com.example.sena.Juana.models.usuarios.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    // 1. Convertir de Entidad (Usuario) a DTO (UsuarioDto)
    @Mapping(source = "nom", target = "nomb")
    @Mapping(source = "ape", target = "apell")
    @Mapping(source = "dir", target = "direc")
    @Mapping(source = "tel", target = "tele")
    UsuarioDto convertiraDto(Usuario usuarioGuardado);

    // 2. Convertir de DTO (UsuarioDto) a Entidad (Usuario)
    @Mapping(source = "nomb", target = "nom")
    @Mapping(source = "apell", target = "ape")
    @Mapping(source = "direc", target = "dir")
    @Mapping(source = "tele", target = "tel")
    Usuario convertiraEntidad(UsuarioDto usuarioDto);
}