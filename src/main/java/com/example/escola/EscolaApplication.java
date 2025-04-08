package com.example.escola;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.escola.domains.CategoriaCurso;
import com.example.escola.domains.Curso;
import com.example.escola.domains.Pessoa;
import com.example.escola.repositories.CategoriaCursoRepository;
import com.example.escola.repositories.CursoRepository;
import com.example.escola.repositories.PessoaRepository;

@SpringBootApplication
public class EscolaApplication {

	@Bean
	public CommandLineRunner init(
		@Autowired CursoRepository cursoRepository,
		@Autowired CategoriaCursoRepository categoriaRepository,
		@Autowired PessoaRepository pessoaRepository
		) {
		return args -> {
			cursoRepository.save(
					new Curso(null, "teste", 2000));
			cursoRepository.save(
					new Curso(null, "teste2", 2050));
			List<Curso> listaCursos = cursoRepository.findAll();
			listaCursos.forEach(System.out::println);

			System.out.println("*** Inserir Categoria ***");
			CategoriaCurso categ = categoriaRepository.save(new CategoriaCurso(null, "Informática"));
			
			System.out.println("*** Vincular Categoria ao curso ***");
			Curso curso = cursoRepository.findAll().get(0);
			curso.setCategoriaCurso(categ);
			cursoRepository.save(curso);

			System.out.println("*** OBTER CURSO POR NOME");
			List<Curso> cursos = cursoRepository.findByNome("teste2");
			cursos.forEach(System.out::println);

			System.out.println("*** Vincular Pessoa ao Curso");
			Pessoa pessoa1 = pessoaRepository.salvar(new Pessoa(null, "Bigeus"));
			Pessoa pessoa2 = pessoaRepository.salvar(new Pessoa(null, "Bigeus222"));
			curso.matricular(pessoa1);
			curso.matricular(pessoa2);
			cursoRepository.save(curso); //enviar pro banco
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(EscolaApplication.class, args);
	}

}
