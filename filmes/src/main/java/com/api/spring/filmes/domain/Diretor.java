package com.api.spring.filmes.domain;

import com.api.spring.filmes.core.crud.CrudDomain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Diretor implements Serializable, CrudDomain<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @JsonIgnoreProperties("diretor")
    @OneToMany(mappedBy = "diretor")
    private List<Filme> filmes = new ArrayList<>();

    public void addFilme(Filme filme){
        this.filmes.add(filme);
    }

    @PreRemove
    private void onRemoveSetNull() {
        for (Filme filme : filmes ) {
            filme.setDiretor(null);
        }
    }
}
