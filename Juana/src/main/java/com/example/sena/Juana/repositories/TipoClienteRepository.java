package com.example.sena.Juana.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sena.Juana.models.usuarios.TiposCliente;

public interface TipoClienteRepository extends JpaRepository<TiposCliente, Byte> {

}
