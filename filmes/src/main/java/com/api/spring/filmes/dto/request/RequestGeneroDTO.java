package com.api.spring.filmes.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestGeneroDTO {

    private Long id;
    @NotBlank
    private String nome;

}
