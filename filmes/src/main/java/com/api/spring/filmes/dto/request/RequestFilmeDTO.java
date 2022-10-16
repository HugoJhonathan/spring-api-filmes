package com.api.spring.filmes.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestFilmeDTO implements Serializable {
    @NotBlank
    private String title;
    private Date data;
    private String poster;
    private Double orcamento;
    private Double receita;
    @JsonProperty("diretor")
    private Long diretorId;
    @JsonProperty("generos")
    private List<Long> generos = new ArrayList<>();
    private String base64;

}