package com.api.spring.filmes.core.crud;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

public abstract class CrudService<ENTITY, ID> {

    @Autowired
    protected CrudRepository<ENTITY, ID> repository;

    public List<ENTITY> listar(){

        return repository.findAll();
    }

    public ENTITY porId(ID id){

        return repository.findById(id).orElse(null);
    }

    public ENTITY criar(ENTITY entity){

        return repository.save(entity);
    }

    public ENTITY editar(ID id, ENTITY entity){

        ENTITY entityRecuperada = porId(id);

        if(Objects.isNull(entityRecuperada)){
            throw new RuntimeException("ID "+id+" não foi encontrado!");
        }

        ENTITY entityParaSalvar = editarEntidade(entityRecuperada, entity);

        return repository.save(entityParaSalvar);

    }

    protected abstract ENTITY editarEntidade(ENTITY entityRecuperada, ENTITY entity);

    public void excluir(ID id){

        repository.deleteById(id);
    }
}
