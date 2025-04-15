package com.example.escola.services;

import java.util.List;

import com.example.escola.DTO.CursoDTO;
import com.example.escola.DTO.CursoRequestDTO;
import com.example.escola.DTO.DadosCursoDTO;

public interface CursoService {
    CursoDTO salvar(CursoRequestDTO cursoRequestDTO);
    List<DadosCursoDTO> listarTodos();
    DadosCursoDTO obterPorId(Long id);
    void editar(Long id, DadosCursoDTO dto);
    void excluir(Long id);
}
