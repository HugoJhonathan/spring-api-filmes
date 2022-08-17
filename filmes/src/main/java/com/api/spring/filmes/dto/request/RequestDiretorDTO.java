package com.api.spring.filmes.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestDiretorDTO {

    private Long id;
    private String nome;
    private List<Long> filmesId = new ArrayList<>();
}
