package com.example.escola.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.escola.models.Curso;


public interface CursoRepository extends JpaRepository<Curso, Long>{
    public List<Curso> findByNome(String nome);
    public List<Curso> findByNomeLike(String nome);
}
