package com.example.escola.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.escola.DTO.CursoDTO;
import com.example.escola.DTO.CursoRequestDTO;
import com.example.escola.DTO.DadosCursoDTO;
import com.example.escola.config.RegraNegocioException;
import com.example.escola.domains.CategoriaCurso;
import com.example.escola.domains.Curso;
import com.example.escola.repositories.CategoriaCursoRepository;
import com.example.escola.repositories.CursoRepository;

import jakarta.transaction.Transactional;

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
    public List<DadosCursoDTO> listarTodos() {
        return cursoRepository.findAll().stream().map((Curso c) -> {
            return DadosCursoDTO.builder()
                    .id(c.getId())
                    .nome(c.getNome())
                    .cargaHoraria(c.getCargaHoraria())
                    .categoria(
                            CategoriaCursoDto.builder()
                                    .id(c.getCategoriaCurso().getId())
                                    .nome(c.getCategoriaCurso().getNome())
                                    .build())
                    .build();
        }).collect(Collectors.toList());
    }

    @Override
    public DadosCursoDTO obterPorId(Long id) {
        return cursoRepository.findById(id).map((Curso c) -> {
            return DadosCursoDTO
                    .builder()
                    .id(c.getId())
                    .nome(c.getNome())
                    .cargaHoraria(c.getCargaHoraria())
                    .categoria(CategoriaCursoDto.builder()
                            .id(c.getCategoriaCurso().getId())
                            .nome(c.getCategoriaCurso().getNome()).build())
                    .build();
        }).orElseThrow(() -> new RegraNegocioException("Curso não encontrado com o ID fornecido"));
    }

    @Override
    @Transactional
    public void excluir(Long id) {
        cursoRepository.deleteById(id);
    }

    @Override
public void editar(Long id, DadosCursoDTO dto) {
Curso curso = cursoRepository.findById(id)
.orElseThrow(() -> new RegraNegocioException("Código do usuário não encontrado."));
CategoriaCurso categoriaCurso =
categoriaCursoRepository.findById(dto.getCategoria().getId())
.orElseThrow(() -> new RegraNegocioException("Categoria não encontrada."));
curso.setNome(dto.getNome());
curso.setCargaHoraria(dto.getCargaHoraria());
curso.setCategoriaCurso(categoriaCurso);
cursoRepository.save(curso);
}

}
