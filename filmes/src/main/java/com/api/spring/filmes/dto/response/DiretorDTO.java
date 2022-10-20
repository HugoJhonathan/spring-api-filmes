package com.api.spring.filmes.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DiretorDTO implements Serializable {

    private Long id;
    private String nome;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
