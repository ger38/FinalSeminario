package com.Gerar.ApiFinal.demo.Repositorys;

import com.Gerar.ApiFinal.demo.Model.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {
}
