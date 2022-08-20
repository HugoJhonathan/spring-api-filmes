package com.api.spring.filmes.converter;

import com.api.spring.filmes.core.crud.CrudConverter;
import com.api.spring.filmes.domain.Genero;
import com.api.spring.filmes.dto.request.RequestGeneroDTO;
import com.api.spring.filmes.dto.response.GeneroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeneroConverter implements CrudConverter<Genero, GeneroDTO, RequestGeneroDTO> {

    @Autowired
    private FilmeConverter filmeConverter;

    @Override
    public GeneroDTO entidadeParaDto(Genero entidade) {

        return new GeneroDTO(entidade.getId(), entidade.getNome());
    }

    @Override
    public Genero dtoCadastroParaEntidade(RequestGeneroDTO dto) {
        var genero = new Genero();
        genero.setNome(dto.getNome());
        return genero;
    }

}
