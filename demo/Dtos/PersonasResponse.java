package com.Gerar.ApiFinal.demo.Dtos;

import lombok.Builder;

import java.util.List;

@Builder
public class PersonasResponse {

    private List<PersonaResponse> personas;
}
