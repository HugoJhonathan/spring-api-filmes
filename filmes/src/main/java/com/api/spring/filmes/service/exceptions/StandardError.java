package com.api.spring.filmes.service.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StandardError implements Serializable {

    private final Instant timestamp = Instant.now();
    private Integer status;
    private String error;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String path;

}
