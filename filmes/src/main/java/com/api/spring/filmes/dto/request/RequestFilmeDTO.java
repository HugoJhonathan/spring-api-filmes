package com.api.spring.filmes.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data;
    @Size(max = 2)
    private String poster;
    private Double orcamento;
    private Double receita;
    @JsonProperty("diretor_id")
    private Long diretorId;
    @JsonProperty("generos_id")
    private List<Long> generosId = new ArrayList<>();

}