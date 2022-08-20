package com.api.spring.filmes.converter;

import com.api.spring.filmes.core.crud.CrudConverter;
import com.api.spring.filmes.domain.Diretor;
import com.api.spring.filmes.dto.request.RequestDiretorDTO;
import com.api.spring.filmes.dto.response.DiretorDTO;
import com.api.spring.filmes.dto.response.full.DiretorFullDTO;
import com.api.spring.filmes.dto.response.full.FilmeFullDTO;
import com.api.spring.filmes.service.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class DiretorConverter implements CrudConverter<Diretor, DiretorDTO, DiretorFullDTO, RequestDiretorDTO> {

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
    public Diretor dtoCadastroParaEntidade(RequestDiretorDTO dto) {
        var diretor = new Diretor();
        diretor.setNome(dto.getNome());
        return diretor;
    }

    @Autowired
    FilmeConverter filmeConverter;

    @Override
    public DiretorFullDTO entidadeParaDtoFull(Diretor entidade) {

        List<FilmeFullDTO> filmes = new ArrayList<>();

        if(!Objects.isNull(entidade.getFilmes())) {
            filmes = entidade.getFilmes()
                    .stream()
                    .map(filmeConverter::entidadeParaDtoFull)
                    .collect(Collectors.toList());
        }

        return new DiretorFullDTO(entidade.getId(), entidade.getNome(), filmes);
    }

}