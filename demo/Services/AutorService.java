package com.Gerar.ApiFinal.demo.Services;


import org.springframework.stereotype.Service;
import com.Gerar.ApiFinal.demo.Dtos.*;
import com.Gerar.ApiFinal.demo.Mappers.*;
import com.Gerar.ApiFinal.demo.Model.*;
import com.Gerar.ApiFinal.demo.Repositorys.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private AutorMapper autorMapper;

    @Autowired
    private PersonaService personaService;

    public ResponseEntity setAutor(AutorRequest autorRequest) throws SQLException {
        Autor autor = new Autor();
        setPersonaNuevaOExistente(autorRequest, autor);
        autor = autorMapper.autorRequestToAutor(autorRequest, autor);

        try {
            autorRepository.save(autor);
        }
        catch (RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getCause().getLocalizedMessage());
        }
        return ResponseEntity.ok("Autor guardado: " + autor.getPersona().getNombre() + " "
                + autor.getPersona().getApellido());
    }

    // Toma los datos de la persona de ProfesorRequest, verifica si existe la persona. Si no es así la crea
    // y si existe, toma esos datos y los asigna a profesor.
    public void setPersonaNuevaOExistente(AutorRequest autorRequest, Autor autor) {
        if(personaService.findByDni(autorRequest.getPersona().getDni()).isEmpty()) {
            Persona persona = autorMapper.autorRequestToPersona(autorRequest);
            autor.setPersona(persona);
            personaService.save(persona);
        }
        else {
            autor.setPersona(personaService.findByDni(autorRequest.getPersona().getDni()).get(0));
        }
    }

    public void deleteAutor(Long id) {
        autorRepository.deleteById(id);
    }

    public AutorResponse buildAutorResponse(Persona persona) {
        List<PersonaResponse> personaResponseList = new ArrayList<>();

        PersonaResponse personaResponse = PersonaResponse.builder()
                .apellido(persona.getApellido())
                .nombre(persona.getNombre())
                .direccion(persona.getDireccion())
                .telefono(persona.getTelefono())
                .dni(persona.getDni())
                .mail(persona.getMail())
                .build();

        AutorResponse autorResponse = AutorResponse.builder()
                .autor(personaResponse)
                .build();

        return autorResponse;
    }

}
