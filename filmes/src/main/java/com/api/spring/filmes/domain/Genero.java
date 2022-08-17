package com.api.spring.filmes.domain;

import com.api.spring.filmes.core.crud.CrudDomain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Genero implements Serializable, CrudDomain<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @JsonIgnoreProperties("generos")
    @ManyToMany(mappedBy = "generos")
    private List<Filme> filmes;

    @PreRemove
    private void onRemoveDelete() {
        for (Filme filme : filmes) {
            filme.getGeneros().remove(this);
        }
    }

}