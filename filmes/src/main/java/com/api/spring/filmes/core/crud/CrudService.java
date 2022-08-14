package com.api.spring.filmes.core.crud;

import com.api.spring.filmes.core.crud.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import java.util.Objects;

public abstract class CrudService<E, ID> {

    @Autowired
    protected CrudRepository<E, ID> repository;

    public List<E> listar(){

        return repository.findAll();
    }

    public E porId(ID id){

        var entity = repository.findById(id).orElse(null);

        if(Objects.isNull(entity)){
            throw new ResourceNotFoundException(id);
        }
        return entity;
    }

    public E criar(E entity){

        return repository.save(entity);
    }

    public E editar(ID id, E entity){

        E entityRecuperada = porId(id);

        E entityParaSalvar = editarEntidade(entityRecuperada, entity);

        return repository.save(entityParaSalvar);
    }
    protected abstract E editarEntidade(E entityRecuperada, E entity);

    public void excluir(ID id){
        try{
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
    }

    public List<E> findByNomeStartingWith(String nome){

        return repository.findByNomeStartingWith(nome);

    }
}
