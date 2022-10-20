package com.api.spring.filmes.domain;

import com.api.spring.filmes.core.crud.CrudDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@OnDelete(action = OnDeleteAction.NO_ACTION)
public class Diretor extends BaseEntity implements Serializable, CrudDomain<Long> {

    @Column(unique = true)
    private String nome;


}
