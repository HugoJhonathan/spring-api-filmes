package com.api.spring.filmes.dto.response.full;

import com.api.spring.filmes.dto.response.FilmeDTO;
import com.api.spring.filmes.dto.response.GeneroDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GeneroFullDTO implements Serializable {
    
    private GeneroDTO genero;
    private List<FilmeDTO> filmes = new ArrayList<>();

}
