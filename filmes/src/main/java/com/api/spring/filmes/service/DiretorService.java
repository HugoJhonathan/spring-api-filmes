package com.api.spring.filmes.service;

import com.api.spring.filmes.core.crud.CrudService;
import com.api.spring.filmes.core.crud.exceptions.ResourceNotFoundException;
import com.api.spring.filmes.domain.Diretor;
import com.api.spring.filmes.domain.Filme;
import com.api.spring.filmes.repository.DiretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Objects;

@Service
public class DiretorService extends CrudService<Diretor, Long> {

    @Override
    protected Diretor criar(Diretor entity) {
        return repository.save(entity);
    }

    @Override
    protected Diretor editarEntidade(Diretor entityRecuperada, Diretor entity) {
        entityRecuperada.setNome(entity.getNome());
        return entityRecuperada;
    }

}