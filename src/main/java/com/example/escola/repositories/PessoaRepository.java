package com.example.escola.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.escola.models.Pessoa;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class PessoaRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Pessoa salvar(Pessoa pessoa){
        return entityManager.merge(pessoa);
    }

    public List<Pessoa> obterTodos(){
        return entityManager.createQuery("from Pessoa", Pessoa.class).getResultList();
    }
}
