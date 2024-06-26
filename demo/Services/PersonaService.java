package com.Gerar.ApiFinal.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import com.Gerar.ApiFinal.demo.Model.*;
import com.Gerar.ApiFinal.demo.Dtos.*;
import com.Gerar.ApiFinal.demo.Repositorys.*;
import com.Gerar.ApiFinal.demo.Mappers.*;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
// Clase que contiene la
// lógica para trabajar con el modelo Persona.
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PersonaMapper personaMapper;

    public ResponseEntity newPersona(PersonaRequest personaRequest) {
        Boolean existePersona = findByDni(personaRequest.getDni()).isEmpty();
        if(existePersona){
            Persona persona = personaRequestToNewPersona(personaRequest);
            savePersona(persona);
            return ResponseEntity.ok("Persona guardada: " + persona.getNombre() + " " + persona.getApellido());
        }
        else {
            return ResponseEntity.badRequest().body("La persona con el DNI especificado ya existe.");
        }
    }

    public ResponseEntity updatePersonaByDni(PersonaRequest personaRequest) {

        try {
            Persona persona = personaRepository.findByDni(personaRequest.getDni()).get(0);
            persona = personaRequestToExistedPersona(personaRequest);
            personaRepository.save(persona);
            return ResponseEntity.ok("Persona actualizada: " + persona.getNombre() + " " + persona.getApellido());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("No existen personas con el dni: " + personaRequest.getDni());
        }
    }

    public ResponseEntity updatePersona(PersonaRequest personaRequest, Long id) {

        try {
            Persona persona = personaRepository.getById(id);
            persona = personaRequestToExistedPersona(personaRequest);
            personaRepository.save(persona);
            return ResponseEntity.ok("Persona actualizada: " + persona.getNombre() + " " + persona.getApellido());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("No existen personas con el id: " + id);
        }
    }

    public void savePersona(Persona persona){
        personaRepository.save(persona);
    }

    public Persona personaRequestToNewPersona(PersonaRequest personaRequest) {
        return personaMapper.personaRequestToPersona(personaRequest);
    }

    public Persona personaRequestToExistedPersona(PersonaRequest personaRequest) {
        return personaMapper.personaRequestToPersona(personaRequest);
    }

    public PersonasResponse listarPersonas() {
        List<Persona> listaPersonas = personaRepository.findAll();
        return personaMapper.personaListToResponse(listaPersonas);
    }

    public List<Persona> findByDni(String dni) {
        return personaRepository.findByDni(dni);
    }

    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }
}
