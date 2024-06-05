package com.Gerar.ApiFinal.demo.Model;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Table(name = "libro")
@Entity
@Getter
@Builder
public class Libro {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String nombre;
    @ManyToOne
    private Biblioteca biblioteca;
    private Integer anio;
}
