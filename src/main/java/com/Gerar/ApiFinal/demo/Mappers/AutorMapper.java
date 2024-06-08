package com.Gerar.ApiFinal.demo.Mappers;

import com.Gerar.ApiFinal.demo.Dtos.AutorRequest;
import com.Gerar.ApiFinal.demo.Dtos.AutorResponse;
import com.Gerar.ApiFinal.demo.Dtos.LibroRequest;
import com.Gerar.ApiFinal.demo.Dtos.PersonaResponse;
import com.Gerar.ApiFinal.demo.Model.Autor;
import com.Gerar.ApiFinal.demo.Model.Libro;
import com.Gerar.ApiFinal.demo.Model.Persona;
import com.Gerar.ApiFinal.demo.Services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AutorMapper {

    @Autowired
    private LibroService libroService;

    public Autor autorRequestToAutor(AutorRequest autorRequest, Autor autor){

        List<Libro> libroList = new ArrayList<>();
        for (LibroRequest libroRequest : autorRequest.getLibros()) {

            Libro libro = Libro.builder()
                    .nombre(libroRequest.getNombre())
                    .anio(libroRequest.getAnio())
                    .build();

            libro = libroService.setLibroNuevaOExistente(libroRequest, libro);
            libroList.add(libro);
        }

        autor.setLibros(libroList);
        return autor;
    }



    public Persona autorRequestToPersona(AutorRequest autorRequest) {

        Persona persona = Persona.builder()
                .nombre(autorRequest.getPersona().getNombre())
                .apellido(autorRequest.getPersona().getApellido())
                .dni(autorRequest.getPersona().getDni())
                .direccion(autorRequest.getPersona().getDireccion())
                .telefono(autorRequest.getPersona().getTelefono())
                .mail(autorRequest.getPersona().getMail())
                .build();

        return persona;
    }

    public AutorResponse personaToAutor (Persona persona, List<Libro> libros) {
        PersonaResponse autor = PersonaResponse.builder()
                .apellido(persona.getApellido())
                .nombre(persona.getNombre())
                .mail(persona.getMail())
                .dni(persona.getDni())
                .direccion(persona.getDireccion())
                .telefono(persona.getTelefono())
                .build();

        AutorResponse autorResponse = AutorResponse.builder()
                .autor(autor)
                .build();

//        autorResponse.setLibros();
        return null;
    }
}

