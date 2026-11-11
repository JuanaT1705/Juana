package com.example.sena.Juana.models.usuarios;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Entity 
@Table (name = "trabajadores")
@PrimaryKeyJoinColumn (name = "trabajador_id")
@Getter @Setter 
@AllArgsConstructor 
@NoArgsConstructor
@SuperBuilder 
public class Trabajador extends Usuario {

       @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "tipo_Trabajador", nullable = false)

    private TiposTrabajador cargo;

    private Double sueldo;





}
