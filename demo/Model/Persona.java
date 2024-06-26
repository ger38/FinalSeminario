package com.Gerar.ApiFinal.demo.Model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Table(name = "persona")
@Entity
@Builder
@Getter
public class Persona {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String mail;
    private String direccion;
}

