package com.api.spring.filmes.dto.response.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DiretorFullDTO implements Serializable {

    private Long id;
    private String nome;
    private List<FilmeFullDTO> filmes = new ArrayList<>();

}
