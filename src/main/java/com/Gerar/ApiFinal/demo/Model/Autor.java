package com.Gerar.ApiFinal.demo.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Builder;

import java.util.List;

@Entity
@Table(name = "autor")
@Data
@Builder
public class Autor {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne
    private Persona persona;
    @OneToMany
    private List<Libro> libros;
}
