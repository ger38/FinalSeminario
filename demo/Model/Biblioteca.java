package com.Gerar.ApiFinal.demo.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "biblioteca")
@Entity
@Getter
@Setter
public class Biblioteca {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String nombre;
}
