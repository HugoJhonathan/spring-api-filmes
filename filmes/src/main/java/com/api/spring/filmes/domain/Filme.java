package com.api.spring.filmes.domain;

import com.api.spring.filmes.core.crud.CrudDomain;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Filme extends BaseEntity implements Serializable, CrudDomain<Long> {

    private String title;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date data;
    private String poster;
    private Double orcamento;
    private Double receita;

    @JsonIgnoreProperties("filmes")
    @ManyToOne
    @JoinColumn(name = "diretor_id", referencedColumnName = "id")
    private Diretor diretor;

    @JsonIgnoreProperties("filmes")
    @ManyToMany
    @JoinTable(name = "generos_do_filme",
            joinColumns = @JoinColumn(name = "id_filme"),
            inverseJoinColumns = @JoinColumn(name = "id_genero"))
    private Set<Genero> generos = new LinkedHashSet<>();

    @Lob
    private String base64;

}