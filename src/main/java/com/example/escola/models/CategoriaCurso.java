package com.example.escola.models;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CategoriaCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    
    @OneToMany(mappedBy = "categoriaCurso")
    private List<Curso> cursos;

    public CategoriaCurso(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaCurso() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "CategoriaCurso [id=" + id + ", nome=" + nome + ", cursos=" + cursos + ", getId()=" + getId()
                + ", getNome()=" + getNome() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "]";
    }

}