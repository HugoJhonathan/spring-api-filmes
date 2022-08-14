package com.api.spring.filmes.converter;

import com.api.spring.filmes.core.crud.CrudConverter;
import com.api.spring.filmes.domain.Diretor;
import com.api.spring.filmes.dto.DiretorDTO;
import com.api.spring.filmes.dto.GeneroDTO;
import com.api.spring.filmes.dto.full.DiretorFullDTO;
import com.api.spring.filmes.dto.full.FilmeFullDTO;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class DiretorConverter implements CrudConverter<Diretor, DiretorDTO, DiretorFullDTO> {

    @Override
    public DiretorDTO entidadeParaDto(Diretor entidade) {

        if (Objects.isNull(entidade)) {
            return null;
        }
        return new DiretorDTO(entidade.getId(), entidade.getNome());
    }

    @Override
    public Diretor dtoParaEntidade(DiretorDTO dto) {

        var diretor = new Diretor();
        diretor.setId(dto.getId());
        diretor.setNome(dto.getNome());

        return diretor;
    }

    @Override
    public DiretorFullDTO entidadeParaDtoFull(Diretor entidade) {

        var filmes = entidade.getFilmes() != null ? entidade.getFilmes()
                .stream()
                .map(film -> new FilmeFullDTO(film.getId(),
                        film.getTitle(),
                        film.getData(),
                        film.getPoster(),
                        film.getOrcamento(),
                        film.getReceita(),
                        film.getDiretor() != null ? new DiretorDTO(film.getDiretor().getId(), film.getDiretor().getNome()) : null,
                        film.getGeneros() != null ? film.getGeneros().stream().map(gen -> new GeneroDTO(gen.getId(), gen.getNome())).collect(Collectors.toList()) : null
                ))
                .collect(Collectors.toList()) : null;

        return new DiretorFullDTO(entidade.getId(), entidade.getNome(), filmes);
    }

}