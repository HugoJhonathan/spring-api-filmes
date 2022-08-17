package com.api.spring.filmes.domain;

import com.api.spring.filmes.core.crud.CrudDomain;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Filme implements Serializable, CrudDomain<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date data;
    private String poster;
    private Double orcamento;
    private Double receita;

    @JsonIgnoreProperties("filmes")
    @ManyToOne()
    @JoinColumn(name = "diretor_id", referencedColumnName = "id")
    @Nullable
    private Diretor diretor;

    @JsonIgnoreProperties("filmes")
    @ManyToMany()
    @JoinTable(name = "generos_do_filme",
            joinColumns = @JoinColumn(name = "id_filme"),
            inverseJoinColumns = @JoinColumn(name = "id_genero"))
    private Set<Genero> generos =  new HashSet<>();

    public void addGenero(Genero genero){
        this.generos.add(genero);
    }

    public void addDiretor(Diretor diretor){ this.diretor = diretor; }

}