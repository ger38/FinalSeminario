package com.Gerar.ApiFinal.demo.Services;

import org.springframework.stereotype.Service;

import com.Gerar.ApiFinal.demo.Dtos.*;
import com.Gerar.ApiFinal.demo.Model.*;
import com.Gerar.ApiFinal.demo.Repositorys.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> findByNombre(String nombre) {
        return libroRepository.findByNombre(nombre);
    }

    public Libro save (Libro libro) {
        return (Libro) libroRepository.save(libro);
    }

    public Libro setLibroNuevaOExistente(LibroRequest libroRequest, Libro libro) {
        if(libroRepository.findByNombre(libroRequest.getNombre()).isEmpty()) {

            libroRepository.save(libro);
        }
        else {
            libro = libroRepository.findByNombre(libroRequest.getNombre()).get(0);
        }
        return libro;
    }
}

