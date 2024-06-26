package com.Gerar.ApiFinal.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.Gerar.ApiFinal.demo.Dtos.*;
//import com.Gerar.ApiFinal.demo.Dtos.PersonasResponse;
import com.Gerar.ApiFinal.demo.Services.*;

import javax.ws.rs.Produces;
import java.sql.SQLException;


@RequestMapping("/personas")
@Controller
// Permite generar métodos http
// para la carga, obtención o modificación de datos.
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    // Permite cargar una nueva persona con método POST.
    @PostMapping("/nuevaPersona")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity nuevaPersona(@RequestBody PersonaRequest personaRequest) {

        return personaService.newPersona(personaRequest);
    }

    @PutMapping("/actualizarPersona/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity actualizarPersona(@PathVariable("id") Long id, @RequestBody PersonaRequest personaRequest) {

        return personaService.updatePersona(personaRequest, id);
    }

    @PutMapping("/actualizarPersona")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity actualizarPersonaPorDni(@RequestBody PersonaRequest personaRequest) {

        return personaService.updatePersonaByDni(personaRequest);
    }

    // Permite listar personas con GET.
    @GetMapping("/listarPersonas")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PersonasResponse listarPersonas(){

        return personaService.listarPersonas();
    }

    @DeleteMapping("/borrarPersona/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity borrarPersona(@PathVariable("id") Long id) throws SQLException {

        try {
            personaService.deletePersona(id);
            return ResponseEntity.ok("Registro eliminado");
        }

        catch(Exception ex) {
            return ResponseEntity.badRequest().body("No se pudo eliminar el registro. El error es: " + ex.getMessage());
        }
    }
}

