package com.api.spring.filmes.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Filme implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Date data;
    private String poster;
    private Double orcamento;
    private Double receita;
    @ManyToOne()
    @JoinColumn(name = "diretor_id", referencedColumnName = "id", nullable = true)
    private Diretor diretor;
    @ManyToMany()
    @JoinTable(name = "generos_do_filme",
            joinColumns = @JoinColumn(name = "id_filme"),
            inverseJoinColumns = @JoinColumn(name = "id_genero"))
    private List<Genero> generos =  new ArrayList<>();
}