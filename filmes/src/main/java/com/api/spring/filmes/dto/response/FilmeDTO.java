package com.api.spring.filmes.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilmeDTO implements Serializable {

    private Long id;
    private String title;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date data;
    private String poster;
    private Double orcamento;
    private Double receita;
    private DiretorDTO diretor;
    private List<GeneroDTO> generos = new ArrayList<>();
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
