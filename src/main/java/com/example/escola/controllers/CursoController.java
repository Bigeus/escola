package com.example.escola.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.escola.DTO.CursoDTO;
import com.example.escola.DTO.CursoRequestDTO;
import com.example.escola.DTO.DadosCursoDTO;
import com.example.escola.services.CursoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    private CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping()
    public List<DadosCursoDTO> listarTodos() {
        return cursoService.listarTodos();
    }

    @GetMapping("{id}")
    public DadosCursoDTO ObterPorId(@PathVariable Long id) {
        return cursoService.obterPorId(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        cursoService.excluir(id);
    }

    @PostMapping()
    public CursoDTO postCurso(@Valid @RequestBody CursoRequestDTO curso) {
        return cursoService.salvar(curso);
    }

}
