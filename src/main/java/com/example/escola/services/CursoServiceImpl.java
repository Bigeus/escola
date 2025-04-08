package com.example.escola.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.escola.DTO.CursoDTO;
import com.example.escola.DTO.CursoRequestDTO;
import com.example.escola.config.RegraNegocioException;
import com.example.escola.domains.CategoriaCurso;
import com.example.escola.domains.Curso;
import com.example.escola.repositories.CategoriaCursoRepository;
import com.example.escola.repositories.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private CategoriaCursoRepository categoriaCursoRepository;
    
    
    @Override
    public CursoDTO salvar(CursoRequestDTO cursoDTO) {
       CategoriaCurso categ = categoriaCursoRepository.findById(
        cursoDTO.getCategoriaCursoId()).orElseThrow(() -> new RegraNegocioException("Código não encontrado."));

        Curso curso = new Curso();
        curso.setNome(cursoDTO.getNome());
        curso.setCargaHoraria(cursoDTO.getCargaHoraria());
        curso.setCategoriaCurso(categ);
        Curso c = cursoRepository.save(curso);

        CursoDTO cursoReponse = new CursoDTO();
        cursoReponse.setId(c.getId());
        cursoReponse.setNome(c.getNome());
        return cursoReponse;
    }


    @Override
    public List<CursoDTO> obterTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obterTodos'");
    }


    
}
