package com.example.sena.Juana.models.usuarios;



import jakarta.persistence.Column;
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
@Table (name = "clientes")
@PrimaryKeyJoinColumn (name = "cliente_id")
@Getter @Setter 
@AllArgsConstructor 
@NoArgsConstructor 
@SuperBuilder 
public class Cliente extends Usuario {

    //@Enumerated(EnumType.STRING) //extrae del enum texto

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "tipo_Cliente", nullable = false)
   private TiposCliente tipoCliente;
    

    @Column (name="puntos")
    private Integer puntos;


}
