package com.Gerar.ApiFinal.demo.mocks;
import com.Gerar.ApiFinal.demo.Model.Libro;

import java.util.ArrayList;
import java.util.List;
public class LibroMocks {

    public static Libro mockEntity() {

        Libro libro = Libro.builder()
                .id(1L)
                .nombre("Seminario de Programación")
                .anio(2)
                .carrera(BibliotecaMock.mockEntity())
                .build();

        return libro;
    }

    public static List<Libro> mockList() {
        List<Libro> libross = new ArrayList<>();
        libros.add(mockEntity());
        return libros;
    }
}
}
