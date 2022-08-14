package com.api.spring.filmes.converter;

import com.api.spring.filmes.core.crud.CrudConverter;
import com.api.spring.filmes.domain.Filme;
import com.api.spring.filmes.dto.DiretorDTO;
import com.api.spring.filmes.dto.FilmeDTO;
import com.api.spring.filmes.dto.GeneroDTO;
import com.api.spring.filmes.dto.full.FilmeFullDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FilmeConverter implements CrudConverter<Filme, FilmeDTO, FilmeFullDTO> {

    @Override
    public FilmeDTO entidadeParaDto(Filme filme){

        return new FilmeDTO(filme.getId(), filme.getTitle(), filme.getData(), filme.getPoster(), filme.getOrcamento(), filme.getReceita());
    }

    @Override
    public Filme dtoParaEntidade(FilmeDTO dto) {

        var filme = new Filme();
        filme.setId(dto.getId());
        filme.setTitle(dto.getTitle());
        filme.setData(dto.getData());
        filme.setPoster(dto.getPoster());
        filme.setOrcamento(dto.getOrcamento());
        filme.setReceita(dto.getReceita());

        return filme;
    }

    @Override
    public FilmeFullDTO entidadeParaDtoFull(Filme filme){

        DiretorDTO diretor = filme.getDiretor() != null ? new DiretorDTO(filme.getDiretor().getId(), filme.getDiretor().getNome()) : null;


            List<GeneroDTO> generos = filme.getGeneros() != null ? filme.getGeneros()
                    .stream()
                    .map(gen -> new GeneroDTO(gen.getId(), gen.getNome()))
                    .collect(Collectors.toList()) : null;

        return new FilmeFullDTO(filme.getId(), filme.getTitle(), filme.getData(), filme.getPoster(), filme.getOrcamento(), filme.getReceita(), diretor, generos);
    }

}
