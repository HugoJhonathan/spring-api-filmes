package com.api.spring.filmes.converter;

import com.api.spring.filmes.core.crud.CrudConverter;
import com.api.spring.filmes.domain.Genero;
import com.api.spring.filmes.dto.request.RequestGeneroDTO;
import com.api.spring.filmes.dto.response.GeneroDTO;
import com.api.spring.filmes.dto.response.full.FilmeFullDTO;
import com.api.spring.filmes.dto.response.full.GeneroFullDTO;
import com.api.spring.filmes.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class GeneroConverter implements CrudConverter<Genero, GeneroDTO, GeneroFullDTO, RequestGeneroDTO> {

    @Autowired
    private FilmeConverter filmeConverter;

    @Override
    public GeneroDTO entidadeParaDto(Genero entidade) {

        return new GeneroDTO(entidade.getId(), entidade.getNome());
    }

    @Override
    public Genero dtoParaEntidade(GeneroDTO dto) {

        var genero = new Genero();
        genero.setId(dto.getId());
        genero.setNome(dto.getNome());

        return genero;
    }

    @Override
    public Genero dtoCadastroParaEntidade(RequestGeneroDTO dto) {
        var genero = new Genero();
        genero.setNome(dto.getNome());
        return genero;
    }

    @Override
    public GeneroFullDTO entidadeParaDtoFull(Genero entidade) {
        List<FilmeFullDTO> filmes = new ArrayList<>();

        if(!Objects.isNull(entidade.getFilmes())) {
            filmes = entidade.getFilmes()
                    .stream()
                    .map(filmeConverter::entidadeParaDtoFull)
                    .collect(Collectors.toList());
        }

        return new GeneroFullDTO(entidade.getId(), entidade.getNome(), filmes);
    }

}
