package com.example.sena.Juana.servicesImplement;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.sena.Juana.dtos.ClienteDto;
import com.example.sena.Juana.dtos.ClienteDtoResponse;
import com.example.sena.Juana.mappers.ClienteMapper;
import com.example.sena.Juana.models.usuarios.Cliente;
import com.example.sena.Juana.models.usuarios.TiposCliente;
import com.example.sena.Juana.repositories.ClienteRepository;
import com.example.sena.Juana.repositories.TipoClienteRepository;
import com.example.sena.Juana.services.ClienteServices;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class ClienteServicesImplement implements ClienteServices {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    private final TipoClienteRepository tiCliRepo;

    @Override
    public ClienteDtoResponse guardar(ClienteDto clienteDto) {

        //1. buscar id de tipo clliente en la base de datos

        TiposCliente tipo = tiCliRepo.findById(clienteDto.getTipCli())
        .orElseThrow(()-> new EntityNotFoundException("Tipo de cliente no encontrado"));
        
        //2. Convertir DTO a entidad
        Cliente cliente = clienteMapper.toEntidad(clienteDto);
        
        //3. El ID del cliente debe ser nul porque es autoincrementable
        cliente.setId(null);

        //4. Asigna TipoCliente "Id"
        cliente.setTipoCliente(tipo);


        //5. Guardar en la base de datos
        Cliente clienteGuardado = clienteRepository.save(cliente); 

        return clienteMapper.toDto(clienteGuardado);
    }

    //Listar Todos
    @Override 
    public List<ClienteDtoResponse> listarTodos(){
        return clienteRepository.findAll()
        .stream()
        .map(clienteMapper::toDto)
        .toList();
    }

    //Consultar por id
    @Override 
    public ClienteDtoResponse buscarId(Long id){
        Cliente cliente=clienteRepository.findById(id)
        .orElseThrow(()-> new EntityNotFoundException("cliente no encontrado"+id));

        return clienteMapper.toDto(cliente);
    }

    //Actualizar un usuario

    @Override 
    public ClienteDtoResponse actualizar(Long id, ClienteDto clienteDto){
        Cliente clienteExistente = clienteRepository.findById(id)
        .orElseThrow(()-> new EntityNotFoundException("cliente no encontrado, "+id));

        //actualizar datos 

        clienteExistente.setNom(clienteDto.getNomb());
        clienteExistente.setApe(clienteDto.getApell());
        clienteExistente.setDir(clienteDto.getDirec());
        clienteExistente.setTel(clienteDto.getTele());

        //atributos propios de cliente
        clienteExistente.setPuntos(clienteDto.getPts());
        clienteExistente.setTipoCliente(tiCliRepo.findById(clienteDto.getTipCli())
        .orElseThrow(()-> new EntityNotFoundException("Tipo de cliente no encontrado, "+clienteDto.getTipCli())));

        Cliente clienteActualizado = clienteRepository.save(clienteExistente);

        return clienteMapper.toDto(clienteActualizado);
    }

    //Eliminar un usuario
    @Override
    public ClienteDtoResponse delete(Long id, ClienteDto clienteDto) {
        Cliente clienteExistente = clienteRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado, " + id));

        clienteRepository.delete(clienteExistente);
        return clienteMapper.toDto(clienteExistente);
    }

}
