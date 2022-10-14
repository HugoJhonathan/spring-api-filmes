package com.api.spring.filmes.domain;

import com.api.spring.filmes.core.crud.CrudDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Genero extends BaseEntity implements Serializable, CrudDomain<Long> {

    private String nome;

}