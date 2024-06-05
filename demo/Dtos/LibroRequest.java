package com.Gerar.ApiFinal.demo.Dtos;

import lombok.Data;

@Data
public class LibroRequest {

    private String nombre;
    private Integer anio;
    private BibliotecaRequest biblioteca;
}
