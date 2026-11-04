package com.example.sena.Juana.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sena.Juana.models.usuarios.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
