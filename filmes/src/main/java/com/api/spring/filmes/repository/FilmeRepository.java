package com.api.spring.filmes.repository;

import com.api.spring.filmes.core.crud.CrudRepository;
import com.api.spring.filmes.domain.Filme;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends CrudRepository<Filme, Long> {

}
