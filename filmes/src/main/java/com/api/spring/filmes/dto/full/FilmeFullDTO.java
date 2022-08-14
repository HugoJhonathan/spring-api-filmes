package com.api.spring.filmes.dto.full;

import com.api.spring.filmes.dto.DiretorDTO;
import com.api.spring.filmes.dto.GeneroDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilmeFullDTO implements Serializable {

    private Long id;
    private String title;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date data;
    private String poster;
    private Double orcamento;
    private Double receita;
    private DiretorDTO diretor;
    private List<GeneroDTO> generos = new ArrayList<>();

}
