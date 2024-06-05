package com.Gerar.ApiFinal.demo.Dtos;

import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Builder
@Getter

public class AutorResponse {

    private PersonaResponse autor;
    private List<LibroResponse> libros;
}
