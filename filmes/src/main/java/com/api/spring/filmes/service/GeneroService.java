package com.api.spring.filmes.service;

import com.api.spring.filmes.core.crud.CrudService;
import com.api.spring.filmes.domain.Genero;
import org.springframework.stereotype.Service;

@Service
public class GeneroService extends CrudService<Genero, Long> {

    @Override
    protected Genero criar(Genero entity) {
        return repository.save(entity);
    }

    @Override
    protected Genero editarEntidade(Genero entityRecuperada, Genero entity) {
        entityRecuperada.setNome(entity.getNome());
        return entityRecuperada;
    }


}
