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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        List<GeneroDTO> generos = new ArrayList<>();

        if (!Objects.isNull(filme.getGeneros())) {
            generos = filme.getGeneros()
                    .stream()
                    .map(gen -> new GeneroDTO(gen.getId(), gen.getNome(), gen.getCreatedAt(), gen.getUpdatedAt()))
                    .collect(Collectors.toList());
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
                filme.getUpdatedAt()

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

        if (!Objects.isNull(dto.getGenerosId())) {
            filme.getGeneros().addAll(generoService.findByIdIn(dto.getGenerosId()));
        }

        if (!Objects.isNull(dto.getDiretorId())) {
            filme.setDiretor(diretorService.porId(dto.getDiretorId()));
        }

        return filme;
    }

}
