package com.api.spring.filmes.dto.response.full;

import com.api.spring.filmes.dto.response.DiretorDTO;
import com.api.spring.filmes.dto.response.GeneroDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilmeFullDTO implements Serializable {

    private String title;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data;
    private String poster;
    private Double orcamento;
    private Double receita;
    private DiretorDTO diretor;
    private Set<GeneroDTO> generos = new LinkedHashSet<>();

}
