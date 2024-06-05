package com.Gerar.ApiFinal.demo.Dtos;

import com.Gerar.ApiFinal.demo.Dtos.BibliotecaResponse;
import lombok.Data;

@Data
public class LibroResponse {
    private String nombre;
    private Integer anio;
    private BibliotecaResponse biblioteca;

}
