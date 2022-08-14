package com.api.spring.filmes.service;

import com.api.spring.filmes.core.crud.CrudService;
import com.api.spring.filmes.domain.Diretor;
import org.springframework.stereotype.Service;

@Service
public class DiretorService extends CrudService<Diretor, Long> {

    @Override
    protected Diretor editarEntidade(Diretor entityRecuperada, Diretor entity) {
        entityRecuperada.setNome(entity.getNome());
        return entityRecuperada;
    }

}
