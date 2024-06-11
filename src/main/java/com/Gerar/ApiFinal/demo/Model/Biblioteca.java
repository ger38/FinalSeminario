package com.Gerar.ApiFinal.demo.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
