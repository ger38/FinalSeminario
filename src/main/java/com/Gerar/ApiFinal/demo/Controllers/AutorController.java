package com.Gerar.ApiFinal.demo.Controllers;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import com.Gerar.ApiFinal.demo.Dtos.*;
//import com.Gerar.ApiFinal.demo.Dtos.AutorResponse;
import com.Gerar.ApiFinal.demo.Services.*;

import javax.ws.rs.Produces;
import java.sql.SQLException;


@RequestMapping("/autores")
@Controller
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping("/nuevoAutor")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity nuevoAutor(@RequestBody AutorRequest autorRequest) throws SQLException {

        return autorService.setAutor(autorRequest);
    }
    @DeleteMapping("/borrarAutor/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity borrarAutor(@PathVariable("id") Long id) throws SQLException {

        try {
            autorService.deleteAutor(id);
            return ResponseEntity.ok("Registro eliminado");
        }

        catch(Exception ex) {
            return ResponseEntity.badRequest().body("No se pudo eliminar el registro. El error es: " + ex.getMessage());
        }
    }

    // Permite listar personas con GET.
    @GetMapping("/listarAutor")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AutorResponse listarPersonas(){

//        return AutorService.
        return null;
    }

}

