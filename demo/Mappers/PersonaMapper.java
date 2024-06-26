package com.Gerar.ApiFinal.demo.Mappers;

import org.springframework.stereotype.Service;
import com.Gerar.ApiFinal.demo.Dtos.*;
import com.Gerar.ApiFinal.demo.Dtos.*;
import com.Gerar.ApiFinal.demo.Dtos.PersonasResponse;
import com.Gerar.ApiFinal.demo.Model.Persona;


import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaMapper {

    public Persona personaRequestToPersona(PersonaRequest personaRequest){
        Persona persona = Persona.builder()
                .nombre(personaRequest.getNombre())
                .apellido(personaRequest.getApellido())
                .dni(personaRequest.getDni())
                .direccion(personaRequest.getDireccion())
                .mail(personaRequest.getMail())
                .telefono(personaRequest.getTelefono())
                .build();

        return persona;
    }

    public PersonasResponse personaListToResponse(List<Persona> personas) {
        List<PersonaResponse> personaResponseList = new ArrayList<>();

        for (Persona persona : personas) {
            PersonaResponse personaResponse = PersonaResponse.builder()
                    .apellido(persona.getApellido())
                    .nombre(persona.getNombre())
                    .direccion(persona.getDireccion())
                    .telefono(persona.getTelefono())
                    .dni(persona.getDni())
                    .mail(persona.getMail())
                    .build();

        }
        PersonasResponse personasResponse = PersonasResponse.builder()
                .personas(personaResponseList)
                .build();

        return personasResponse;
    }
}

