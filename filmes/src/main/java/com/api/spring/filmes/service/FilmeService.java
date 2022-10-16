package com.api.spring.filmes.service;

import com.api.spring.filmes.core.crud.CrudService;
import com.api.spring.filmes.domain.Diretor;
import com.api.spring.filmes.domain.Filme;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class FilmeService extends CrudService<Filme, Long> {

    private DiretorService diretorService;

    @Override
    protected Filme editarEntidade(Filme entityRecuperada, Filme entity) {

        if (!Objects.isNull(entity.getDiretor())) {
            Diretor diretor = diretorService.porId(entity.getDiretor().getId());
            entityRecuperada.setDiretor(diretor);
        }

        entityRecuperada.setTitle(entity.getTitle());
        entityRecuperada.setData(entity.getData());
        entityRecuperada.setPoster(entity.getPoster());
        entityRecuperada.setOrcamento(entity.getOrcamento());
        entityRecuperada.setReceita(entity.getReceita());
        entityRecuperada.setGeneros(entity.getGeneros());
        entityRecuperada.setBase64(entity.getBase64());

        return entityRecuperada;

    }

}
