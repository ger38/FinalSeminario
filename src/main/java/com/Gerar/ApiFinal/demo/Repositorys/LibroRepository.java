package com.Gerar.ApiFinal.demo.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Gerar.ApiFinal.demo.Model.Libro;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LibroRepository extends JpaRepository {
    List<Libro> findByNombre(String nombre);
}


