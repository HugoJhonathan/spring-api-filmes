package com.api.spring.filmes.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilmeDTO implements Serializable {

    private Long id;
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date data;
    private String poster;
    private Double orcamento;
    private Double receita;
    private DiretorDTO diretor;
    private Set<GeneroDTO> generos = new LinkedHashSet<>();
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String base64;

}
