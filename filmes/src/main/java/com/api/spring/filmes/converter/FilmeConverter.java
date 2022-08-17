package com.api.spring.filmes.converter;

import com.api.spring.filmes.core.crud.CrudConverter;
import com.api.spring.filmes.domain.Diretor;
import com.api.spring.filmes.domain.Filme;
import com.api.spring.filmes.domain.Genero;
import com.api.spring.filmes.dto.request.RequestFilmeDTO;
import com.api.spring.filmes.dto.response.DiretorDTO;
import com.api.spring.filmes.dto.response.FilmeDTO;
import com.api.spring.filmes.dto.response.GeneroDTO;
import com.api.spring.filmes.dto.response.full.FilmeFullDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class FilmeConverter implements CrudConverter<Filme, FilmeDTO, FilmeFullDTO, RequestFilmeDTO> {

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
    public Filme dtoCadastroParaEntidade(RequestFilmeDTO dto) {

        Filme filme = new Filme();
        filme.setId(dto.getId());
        filme.setTitle(dto.getTitle());
        filme.setData(dto.getData());
        filme.setPoster(dto.getPoster());
        filme.setOrcamento(dto.getOrcamento());
        filme.setReceita(dto.getReceita());

        if(!Objects.isNull(dto.getGenerosId())){
            List<Long> generosId = dto.getGenerosId();
            for(Long id : generosId){
                Genero genero = new Genero();
                genero.setId(id);
                filme.addGenero(genero);
            }
        }

        if(!Objects.isNull(dto.getDiretorId())) {
            Diretor diretor = new Diretor();
            diretor.setId(dto.getDiretorId());
            filme.setDiretor(diretor);
        }

        return filme;
    }

    @Override
    public FilmeFullDTO entidadeParaDtoFull(Filme filme){

        DiretorDTO diretor = null;
        List<GeneroDTO> generos = new ArrayList<>();

        if(!Objects.isNull(filme.getGeneros())) {
            generos = filme.getGeneros()
                .stream()
                .map(gen -> new GeneroDTO(gen.getId(), gen.getNome()))
                .collect(Collectors.toList());
        }

        if(!Objects.isNull(filme.getDiretor())) {
            diretor = new DiretorDTO();
            diretor.setId(filme.getDiretor().getId());
            diretor.setNome(filme.getDiretor().getNome());
        }

        return new FilmeFullDTO(filme.getId(), filme.getTitle(), filme.getData(), filme.getPoster(), filme.getOrcamento(), filme.getReceita(), diretor, generos);
    }

}
