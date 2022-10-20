package com.api.spring.filmes.converter;

import com.api.spring.filmes.core.crud.CrudConverter;
import com.api.spring.filmes.domain.Filme;
import com.api.spring.filmes.dto.request.RequestFilmeDTO;
import com.api.spring.filmes.dto.response.DiretorDTO;
import com.api.spring.filmes.dto.response.FilmeDTO;
import com.api.spring.filmes.dto.response.GeneroDTO;
import com.api.spring.filmes.service.DiretorService;
import com.api.spring.filmes.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FilmeConverter implements CrudConverter<Filme, FilmeDTO, RequestFilmeDTO> {

    @Autowired
    private DiretorService diretorService;

    @Autowired
    private GeneroService generoService;

    @Override
    public FilmeDTO entidadeParaDto(Filme filme) {

        DiretorDTO diretor = null;
        Set<GeneroDTO> generos = new LinkedHashSet<>();

        if (!Objects.isNull(filme.getGeneros())) {
            generos = filme.getGeneros()
                    .stream()
                    .map(gen -> new GeneroDTO(gen.getId(), gen.getNome(), gen.getCreatedAt(), gen.getUpdatedAt()))
                    .collect(Collectors.toSet());
        }

        if (!Objects.isNull(filme.getDiretor())) {
            diretor = new DiretorDTO(filme.getDiretor().getId(), filme.getDiretor().getNome(), filme.getDiretor().getCreatedAt(), filme.getDiretor().getUpdatedAt());
        }


        return new FilmeDTO(filme.getId(),
                filme.getTitle(),
                filme.getData(),
                filme.getPoster(),
                filme.getOrcamento(),
                filme.getReceita(),
                diretor,
                generos,
                filme.getCreatedAt(),
                filme.getUpdatedAt(),
                filme.getBase64()

        );
    }

    @Override
    public Filme dtoCadastroParaEntidade(RequestFilmeDTO dto) {

        Filme filme = new Filme();
        filme.setTitle(dto.getTitle());
        filme.setData(dto.getData());
        filme.setPoster(dto.getPoster());
        filme.setOrcamento(dto.getOrcamento());
        filme.setReceita(dto.getReceita());
        filme.setBase64(dto.getBase64());

        if (!Objects.isNull(dto.getGeneros())) {
            filme.getGeneros().addAll(generoService.findByIdIn(dto.getGeneros()));
        }

        if (!Objects.isNull(dto.getDiretorId())) {
            filme.setDiretor(diretorService.porId(dto.getDiretorId()));
        }

        return filme;
    }

}
