package com.api.spring.filmes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GeneroDTO implements Serializable {

    private Long id;
    private String nome;

}
