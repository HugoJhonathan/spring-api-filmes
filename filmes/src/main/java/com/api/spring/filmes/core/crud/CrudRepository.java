package com.api.spring.filmes.core.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface CrudRepository<E, ID> extends JpaRepository<E, ID> {

    List<E> findByNomeStartingWith(String nome);

}
