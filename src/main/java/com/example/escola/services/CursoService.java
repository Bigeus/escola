package com.example.escola.services;

import java.util.List;

import com.example.escola.DTO.CursoDTO;
import com.example.escola.DTO.CursoRequestDTO;

public interface CursoService {
    CursoDTO salvar(CursoRequestDTO cursoRequestDTO);
    List<CursoDTO> obterTodos();
}
