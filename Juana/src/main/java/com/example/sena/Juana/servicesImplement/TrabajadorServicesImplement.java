package com.example.sena.Juana.servicesImplement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sena.Juana.dtos.TrabajadorDto;
import com.example.sena.Juana.mappers.TrabajadorMapper;
import com.example.sena.Juana.models.usuarios.Trabajador;
import com.example.sena.Juana.repositories.TrabajadorRepository;
import com.example.sena.Juana.services.TrabajadorServices;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class TrabajadorServicesImplement implements TrabajadorServices {

    private final TrabajadorRepository trabajadorRepository;
    private final TrabajadorMapper trabajadorMapper;

    @Override
    public TrabajadorDto guardar(TrabajadorDto trabajadorDto) {
        Trabajador trabajador = trabajadorMapper.toEntidad(trabajadorDto);

        Trabajador trabajadorGuardado = trabajadorRepository.save(trabajador);

        return trabajadorMapper.toDto(trabajadorGuardado);
    }

    //Listar Todos
    @Override 
    public List<TrabajadorDto> listarTodos(){
        return trabajadorRepository.findAll()
        .stream()
        .map(trabajadorMapper::toDto)
        .toList();
    }

    //Consultar por id
    @Override 
    public TrabajadorDto buscarId(Long id){
        Trabajador trabajador=trabajadorRepository.findById(id)
        .orElseThrow(()-> new EntityNotFoundException("trabajador no encontrado"+id));

        return trabajadorMapper.toDto(trabajador);


    }

    //Actualizar un usuario

    @Override 
    public TrabajadorDto actualizar(Long id, TrabajadorDto trabajadorDto){
        Trabajador trabajadorExistente = trabajadorRepository.findById(id)
        .orElseThrow(()-> new EntityNotFoundException("trabajador no encontrado, "+id));

        //actualizar datos 

        trabajadorExistente.setNom(trabajadorDto.getNomb());
        trabajadorExistente.setApe(trabajadorDto.getApell());
        trabajadorExistente.setDir(trabajadorDto.getDirec());
        trabajadorExistente.setTel(trabajadorDto.getTele());
        trabajadorExistente.setCargo(trabajadorDto.getCargo());
        trabajadorExistente.setSueldo(trabajadorDto.getSueldo());


        Trabajador trabajadorActualizado = trabajadorRepository.save(trabajadorExistente);

        return trabajadorMapper.toDto(trabajadorActualizado);
    }

    @Override
    public TrabajadorDto delete(Long id, TrabajadorDto trabajadorDto) {
        Trabajador trabajadorExistente = trabajadorRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Trabajador no encontrado, " + id));

        trabajadorRepository.delete(trabajadorExistente);
        return trabajadorMapper.toDto(trabajadorExistente);
    }
}
