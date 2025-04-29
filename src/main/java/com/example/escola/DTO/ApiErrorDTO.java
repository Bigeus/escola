package com.example.escola.DTO;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public class ApiErrorDTO {
    @Getter
    private List<String> erros;

    public ApiErrorDTO(String mensagem){
        this.erros = Arrays.asList(mensagem);
    }

    public ApiErrorDTO(List<String> erros){
        this.erros = erros;
    }
}
