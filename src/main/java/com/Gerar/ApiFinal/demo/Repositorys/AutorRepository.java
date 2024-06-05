package com.Gerar.ApiFinal.demo.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Gerar.ApiFinal.demo.Model.Autor;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
