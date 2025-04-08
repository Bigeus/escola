package com.example.escola.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.escola.DTO.CursoDTO;
import com.example.escola.DTO.CursoRequestDTO;
import com.example.escola.domains.Curso;
import com.example.escola.repositories.CursoRepository;
import com.example.escola.services.CursoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/cursos")
public class CursoController {
    private CursoService cursoService;

    public CursoController(CursoService cursoService){
        this.cursoService = cursoService;
    }

    // @GetMapping()
    // public List<Curso> getTodosCursos() {
    //     return cursoRepository.findall();
    // }
    
    @PostMapping()
    public CursoDTO postMethodName(@RequestBody CursoRequestDTO curso) {
        return cursoService.salvar(curso);
    }
    
}
