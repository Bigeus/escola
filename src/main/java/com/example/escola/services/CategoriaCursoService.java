package com.example.escola.services;

import java.util.List;

public interface CategoriaCursoService {
    CategoriaCursoDto salvar(CategoriaCursoDto categ);
    List<CategoriaCursoDto> obterTodos();
}
