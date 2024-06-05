package com.Gerar.ApiFinal.demo.Dtos;

import lombok.Data;

@Data

public class PersonaRequest {

    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String mail;
    private String direccion;
}
