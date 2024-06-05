package com.Gerar.ApiFinal.demo.Dtos;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
public class AutorRequest {

    private PersonaRequest persona;
    private List<LibroRequest> libro;

    public List<LibroRequest> getLibros () {
        return libro;
    }
}
