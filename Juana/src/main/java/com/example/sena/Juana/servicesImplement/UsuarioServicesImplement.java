package com.example.sena.Juana.servicesImplement;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.sena.Juana.dtos.UsuarioDto;
import com.example.sena.Juana.mappers.UsuarioMapper;
import com.example.sena.Juana.models.usuarios.Usuario;
import com.example.sena.Juana.repositories.UsuarioRepository;
import com.example.sena.Juana.services.UsuarioServices;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class UsuarioServicesImplement implements UsuarioServices {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDto guardar(UsuarioDto usuarioDto) {
        Usuario usuario = usuarioMapper.convertiraEntidad(usuarioDto);

        Usuario usuarioGuardado = usuarioRepository.save(usuario); 

        return usuarioMapper.convertiraDto(usuarioGuardado);
    }

    //Listar Todos
    @Override 
    public List<UsuarioDto> listarTodos(){
        return usuarioRepository.findAll()
        .stream()
        .map(usuarioMapper::convertiraDto)
        .toList();
    }

    //Consultar por id
    @Override 
    public UsuarioDto buscarId(Long id){
        Usuario usuario=usuarioRepository.findById(id)
        .orElseThrow(()-> new EntityNotFoundException("usuario no encontrado"+id));

        return usuarioMapper.convertiraDto(usuario);


    }

    //Actualizar un usuario

    @Override 
    public UsuarioDto actualizar(Long id, UsuarioDto usuarioDto){
        Usuario usuarioExistente = usuarioRepository.findById(id)
        .orElseThrow(()-> new EntityNotFoundException("usuario no encontrado, "+id));

        //actualizar datos 

        usuarioExistente.setNom(usuarioDto.getNomb());
        usuarioExistente.setApe(usuarioDto.getApell());
        usuarioExistente.setDir(usuarioDto.getDirec());
        usuarioExistente.setTel(usuarioDto.getTele());

        Usuario usuarioActualizado = usuarioRepository.save(usuarioExistente);

        return usuarioMapper.convertiraDto(usuarioActualizado);
    }

    @Override
    public UsuarioDto deleteDto(Long id) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado, " + id));

        usuarioRepository.delete(usuarioExistente);
        return usuarioMapper.convertiraDto(usuarioExistente);
    }

}
