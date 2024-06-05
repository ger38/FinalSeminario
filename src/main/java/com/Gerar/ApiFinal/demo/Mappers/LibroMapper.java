package com.Gerar.ApiFinal.demo.Mappers;

import org.springframework.stereotype.Service;
import com.Gerar.ApiFinal.demo.Dtos.BibliotecaRequest;
import com.Gerar.ApiFinal.demo.Dtos.LibroRequest;
import com.Gerar.ApiFinal.demo.Model.Libro;

@Service
public class LibroMapper {

    public Libro libroRequestToLibro(LibroRequest libroRequest) {
        Libro libro = Libro.builder()
                .nombre(libroRequest.getNombre())
                .anio(libroRequest.getAnio())
                .build();
        BibliotecaRequest bibliotecaRequest = new BibliotecaRequest();
        // Acá tiene que llamar al service para buscar.
        bibliotecaRequest.setNombre(libroRequest.getNombre());

        return null;
    }
}

