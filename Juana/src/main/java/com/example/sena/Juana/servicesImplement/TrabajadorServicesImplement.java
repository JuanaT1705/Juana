package com.example.sena.Juana.servicesImplement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sena.Juana.dtos.ClienteDto;
import com.example.sena.Juana.dtos.ClienteDtoResponse;
import com.example.sena.Juana.dtos.TrabajadorDto;
import com.example.sena.Juana.dtos.TrabajadorDtoResponse;

import com.example.sena.Juana.mappers.TrabajadorMapper;
import com.example.sena.Juana.models.usuarios.Cliente;
import com.example.sena.Juana.models.usuarios.TiposTrabajador;
import com.example.sena.Juana.models.usuarios.Trabajador;
import com.example.sena.Juana.repositories.TipoTrabajadorRepository;
import com.example.sena.Juana.repositories.TrabajadorRepository;
import com.example.sena.Juana.services.TrabajadorServices;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class TrabajadorServicesImplement implements TrabajadorServices {

    private final TrabajadorRepository trabajadorRepository;
    private final TrabajadorMapper trabajadorMapper;
    private final TipoTrabajadorRepository tiTraRepo;

    @Override
public TrabajadorDtoResponse guardar(TrabajadorDto trabajadorDto) {

    // 1. buscar id de tipo trabajador en la base de datos
    TiposTrabajador tipo = tiTraRepo.findById(trabajadorDto.getCargo())
    .orElseThrow(()-> new EntityNotFoundException("Tipo de trabajador no encontrado"));
    
    // 2. Convertir DTO a entidad
    Trabajador trabajador = trabajadorMapper.toEntidad(trabajadorDto);
    
    // 3. El ID del trabajador debe ser nulo porque es autoincrementable
    trabajador.setId(null);

    // 4. Asigna TiposTrabajador
    trabajador.setCargo(tipo);

    // 5. Guardar en la base de datos
    Trabajador trabajadorGuardado = trabajadorRepository.save(trabajador); 

    return trabajadorMapper.toDtoResponse(trabajadorGuardado);
}

     //Listar Todos
    @Override 
    public List<TrabajadorDtoResponse> listarTodos(){
        return trabajadorRepository.findAll()
        .stream()
        .map(trabajadorMapper::toDtoResponse)
        .toList();
    }

    //Consultar por id
    @Override 
    public TrabajadorDtoResponse buscarId(Long id){
        Trabajador trabajador=trabajadorRepository.findById(id)
        .orElseThrow(()-> new EntityNotFoundException("trabajador no encontrado"+id));

        return trabajadorMapper.toDtoResponse(trabajador);
    }

     //Actualizar un usuario

    @Override 
    public TrabajadorDtoResponse actualizar(Long id, TrabajadorDto trabajadorDto){
        Trabajador trabajadorExistente = trabajadorRepository.findById(id)
        .orElseThrow(()-> new EntityNotFoundException("trabajador no encontrado, "+id));

        //actualizar datos 

        trabajadorExistente.setNom(trabajadorDto.getNomb());
        trabajadorExistente.setApe(trabajadorDto.getApell());
        trabajadorExistente.setDir(trabajadorDto.getDirec());
        trabajadorExistente.setTel(trabajadorDto.getTele());

        //atributos propios de trabajador
        trabajadorExistente.setSueldo(trabajadorDto.getSueldo());
        trabajadorExistente.setCargo(tiTraRepo.findById(trabajadorDto.getCargo())
        .orElseThrow(()-> new EntityNotFoundException("Tipo de trabajador no encontrado, "+trabajadorDto.getCargo())));

        Trabajador trabajadorActualizado = trabajadorRepository.save(trabajadorExistente);

        return trabajadorMapper.toDtoResponse(trabajadorActualizado);
    }

    //Eliminar un trabajador
    @Override
    public TrabajadorDtoResponse delete(Long id, TrabajadorDto trabajadorDto) {
        Trabajador trabajadorExistente = trabajadorRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Trabajador no encontrado, " + id));

        trabajadorRepository.delete(trabajadorExistente);
        return trabajadorMapper.toDtoResponse(trabajadorExistente);
    }
}