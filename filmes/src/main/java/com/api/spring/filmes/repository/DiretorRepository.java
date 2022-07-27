package com.api.spring.filmes.repository;

import com.api.spring.filmes.core.crud.CrudRepository;
import com.api.spring.filmes.domain.Diretor;
import org.springframework.stereotype.Repository;

@Repository
public interface DiretorRepository extends CrudRepository<Diretor, Long> {

}
