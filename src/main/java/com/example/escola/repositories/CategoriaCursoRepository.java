package com.example.escola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.escola.domains.CategoriaCurso;

public interface CategoriaCursoRepository extends JpaRepository<CategoriaCurso, Integer> {
    
}