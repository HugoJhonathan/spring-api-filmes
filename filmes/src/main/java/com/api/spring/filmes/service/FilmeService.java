package com.api.spring.filmes.service;

import com.api.spring.filmes.core.crud.CrudService;
import com.api.spring.filmes.domain.Filme;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FilmeService extends CrudService<Filme, Long> {

    @Override
    protected Filme editarEntidade(Filme entityRecuperada, Filme entity) {
        entityRecuperada.setTitle(entity.getTitle());
        entityRecuperada.setData(new Date());
        entityRecuperada.setPoster(entity.getPoster());
        entityRecuperada.setOrcamento(entity.getOrcamento());
        entityRecuperada.setReceita(entity.getReceita());
        return entityRecuperada;
    }

}
