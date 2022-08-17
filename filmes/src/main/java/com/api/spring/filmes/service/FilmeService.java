package com.api.spring.filmes.service;

import com.api.spring.filmes.core.crud.CrudService;
import com.api.spring.filmes.core.crud.exceptions.ResourceNotFoundException;
import com.api.spring.filmes.domain.Diretor;
import com.api.spring.filmes.domain.Filme;
import com.api.spring.filmes.domain.Genero;
import com.api.spring.filmes.repository.DiretorRepository;
import com.api.spring.filmes.repository.FilmeRepository;
import com.api.spring.filmes.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FilmeService extends CrudService<Filme, Long> {

    @Autowired
    DiretorService diretorService;

    @Autowired
    GeneroService generoService;

    @Override
    protected Filme criar(Filme entity) {
        Diretor diretor = null;
        Set<Genero> generos = new HashSet<>();

       if(!Objects.isNull(entity.getDiretor())){
           diretor = diretorService.porId(entity.getDiretor().getId());
       }
       if(!Objects.isNull(entity.getGeneros())){
           generos = entity.getGeneros()
                   .stream()
                   .map(gen -> generoService.porId(gen.getId()))
                   .collect(Collectors.toSet());
       }
       entity.setDiretor(diretor);
       entity.setGeneros(generos);

       return repository.save(entity);
    }

    @Override
    protected Filme editarEntidade(Filme entityRecuperada, Filme entity) {

        if(!Objects.isNull(entity.getDiretor())) {
            Diretor diretor = diretorService.porId(entity.getDiretor().getId());
            entityRecuperada.setDiretor(diretor);
        }

        entityRecuperada.setTitle(entity.getTitle());
        entityRecuperada.setData(entity.getData());
        entityRecuperada.setPoster(entity.getPoster());
        entityRecuperada.setOrcamento(entity.getOrcamento());
        entityRecuperada.setReceita(entity.getReceita());
        entityRecuperada.setGeneros(entity.getGeneros());

        return entityRecuperada;
    }

}
