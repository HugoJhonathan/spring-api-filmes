package com.api.spring.filmes.repository;

import com.api.spring.filmes.core.crud.CrudRepository;
import com.api.spring.filmes.domain.Genero;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneroRepository extends CrudRepository<Genero, Long> {

    List<Genero> findByNomeStartingWith(String nome);

    List<Genero> findByIdIn(List<Long> ids);

}
