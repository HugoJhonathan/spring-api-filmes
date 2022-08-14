package com.api.spring.filmes.repository;

import com.api.spring.filmes.core.crud.CrudRepository;
import com.api.spring.filmes.domain.Filme;
import com.api.spring.filmes.dto.FilmeDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends CrudRepository<Filme, Long> {

    @Query(value="SELECT f FROM Filme f WHERE f.title LIKE :param || '%'")
    List<Filme> findByNomeStartingWith(@Param(value = "param") String param);

}
