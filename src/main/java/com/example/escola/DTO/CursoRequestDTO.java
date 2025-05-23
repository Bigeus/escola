package com.example.escola.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoRequestDTO {
    private String nome;
    private Integer cargaHoraria;
    private Long categoriaCursoId;
}
