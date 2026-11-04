package com.example.sena.Juana.servicesImplement;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.sena.Juana.dtos.ClienteDto;
import com.example.sena.Juana.mappers.ClienteMapper;
import com.example.sena.Juana.models.usuarios.Cliente;
import com.example.sena.Juana.repositories.ClienteRepository;
import com.example.sena.Juana.services.ClienteServices;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class ClienteServicesImplement implements ClienteServices {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Override
    public ClienteDto guardar(ClienteDto clienteDto) {
        Cliente cliente = clienteMapper.toEntidad(clienteDto);

        Cliente clienteGuardado = clienteRepository.save(cliente); 

        return clienteMapper.toDto(clienteGuardado);
    }

    //Listar Todos
    @Override 
    public List<ClienteDto> listarTodos(){
        return clienteRepository.findAll()
        .stream()
        .map(clienteMapper::toDto)
        .toList();
    }

    //Consultar por id
    @Override 
    public ClienteDto buscarId(Long id){
        Cliente cliente=clienteRepository.findById(id)
        .orElseThrow(()-> new EntityNotFoundException("cliente no encontrado"+id));

        return clienteMapper.toDto(cliente);


    }

    //Actualizar un usuario

    @Override 
    public ClienteDto actualizar(Long id, ClienteDto clienteDto){
        Cliente clienteExistente = clienteRepository.findById(id)
        .orElseThrow(()-> new EntityNotFoundException("cliente no encontrado, "+id));

        //actualizar datos 

        clienteExistente.setNom(clienteDto.getNomb());
        clienteExistente.setApe(clienteDto.getApell());
        clienteExistente.setDir(clienteDto.getDirec());
        clienteExistente.setTel(clienteDto.getTele());

        Cliente clienteActualizado = clienteRepository.save(clienteExistente);

        return clienteMapper.toDto(clienteActualizado);
    }

    @Override
    public ClienteDto delete(Long id, ClienteDto clienteDto) {
        Cliente clienteExistente = clienteRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado, " + id));

        clienteRepository.delete(clienteExistente);
        return clienteMapper.toDto(clienteExistente);
    }

}
