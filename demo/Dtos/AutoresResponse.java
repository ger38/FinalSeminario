package com.Gerar.ApiFinal.demo.Dtos;

import lombok.Data;
import com.Gerar.ApiFinal.demo.Model.Autor;

import java.util.List;
@Data
public class AutoresResponse {

    private List<Autor> autores;
}
