package com.api.spring.filmes.service;

import com.api.spring.filmes.core.crud.CrudService;
import com.api.spring.filmes.domain.Genero;
import com.api.spring.filmes.repository.GeneroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GeneroService extends CrudService<Genero, Long> {

    private final GeneroRepository generoRepository;

    @Override
    protected Genero editarEntidade(Genero entityRecuperada, Genero entity) {
        entityRecuperada.setNome(entity.getNome());
        return entityRecuperada;
    }

    public List<Genero> findByIdIn(List<Long> ids){
        return generoRepository.findByIdIn(ids);
    }


}
