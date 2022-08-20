package com.api.spring.filmes.repository;

import com.api.spring.filmes.core.crud.CrudRepository;
import com.api.spring.filmes.domain.Diretor;
import com.api.spring.filmes.domain.Filme;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiretorRepository extends CrudRepository<Diretor, Long> {

    List<Diretor> findByNomeStartingWith(String nome);

    @Query(value="from Filme f join f.diretor d where d.id=:id")
    List<Filme> recuperarPorIds(@Param("id") Long id);

}
