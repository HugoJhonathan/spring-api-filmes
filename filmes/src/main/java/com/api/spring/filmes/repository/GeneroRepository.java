package com.api.spring.filmes.repository;

import com.api.spring.filmes.core.crud.CrudRepository;
import com.api.spring.filmes.domain.Filme;
import com.api.spring.filmes.domain.Genero;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneroRepository extends CrudRepository<Genero, Long> {

    List<Genero> findByNomeStartingWith(String nome);

    List<Genero> findByIdIn(List<Long> ids);

//  @Query(nativeQuery = true, value="SELECT f.nome FROM filme AS f JOIN generos_do_filme AS gdf ON f.id = gdf.id_filme JOIN genero AS g ON g.id = gdf.id_genero WHERE g.id = 1")
    @Query(value="from Filme f join f.generos g where g.id=:id")
    List<Filme> recuperarPorIds(@Param("id") Long id);

}
