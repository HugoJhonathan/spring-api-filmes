package com.api.spring.filmes.converter;

import com.api.spring.filmes.core.crud.CrudConverter;
import com.api.spring.filmes.domain.Genero;
import com.api.spring.filmes.dto.DiretorDTO;
import com.api.spring.filmes.dto.GeneroDTO;
import com.api.spring.filmes.dto.full.FilmeFullDTO;
import com.api.spring.filmes.dto.full.GeneroFullDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GeneroConverter implements CrudConverter<Genero, GeneroDTO, GeneroFullDTO> {

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
    public GeneroFullDTO entidadeParaDtoFull(Genero entidade) {

        List<FilmeFullDTO> filmes = entidade.getFilmes() != null ? entidade.getFilmes().
                stream()
                .map(film -> new FilmeFullDTO(film.getId(),
                        film.getTitle(),
                        film.getData(),
                        film.getPoster(),
                        film.getOrcamento(),
                        film.getReceita(),
                        film.getDiretor() != null ? new DiretorDTO(film.getDiretor().getId(), film.getDiretor().getNome()) : null,
                        film.getGeneros() != null ? film.getGeneros()
                                .stream().map(gen -> new GeneroDTO(gen.getId(), gen.getNome())).collect(Collectors.toList()) : null
                ))
                .collect(Collectors.toList()) : null;

        return new GeneroFullDTO(entidade.getId(), entidade.getNome(), filmes);
    }

}
