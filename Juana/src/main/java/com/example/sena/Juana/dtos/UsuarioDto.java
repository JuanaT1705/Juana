package com.example.sena.Juana.dtos;



import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter 
@AllArgsConstructor 
@NoArgsConstructor 
@Builder 
public class UsuarioDto {


    private Long id;
    
    @NotBlank (message = "El nombre no puede estar vacío")
    @Size (min = 3, max = 60, message = "El nombre debe tener entre 3 y 60 caracteres")

    private String nomb;
     @NotBlank (message = "El apellido no puede estar vacío")
    @Size (min = 3, max = 60, message = "El apellido debe tener entre 3 y 60 caracteres")

    private String apell;

    @Size (min = 3, max = 60, message = "La dirección debe tener entre 3 y 60 caracteres")
    private String direc;

    @Pattern (regexp = "^[0-9]+$", message = "El teléfono debe tener 10 dígitos")
    private Long telef;
}
