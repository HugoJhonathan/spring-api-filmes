package com.api.spring.filmes.core.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class CrudService<E, ID> {

    @Autowired
    protected CrudRepository<E, ID> repository;

    protected String getGenericName() {
        String name = ((Class<E>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]).getName();
        return name.substring(name.lastIndexOf(".") + 1);
    }

    public List<E> listar() {

        return repository.findAll();
    }

    public E porId(ID id) {

        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(getGenericName() + " id " + id + " not found!"));
    }

    public E criar(E entity) {

        return repository.save(entity);
    }

    public E editar(ID id, E entity) {

        E entityRecuperada = porId(id);

        E entityParaSalvar = editarEntidade(entityRecuperada, entity);

        return repository.save(entityParaSalvar);
    }

    protected abstract E editarEntidade(E entityRecuperada, E entity);

    public void excluir(ID id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(getGenericName() + " id " + id + " not found!");
        }
    }

    public List<E> findByNomeStartingWith(String nome) {

        return repository.findByNomeStartingWith(nome);

    }
}
