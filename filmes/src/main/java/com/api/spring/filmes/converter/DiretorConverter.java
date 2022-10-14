package com.api.spring.filmes.converter;

import com.api.spring.filmes.core.crud.CrudConverter;
import com.api.spring.filmes.domain.Diretor;
import com.api.spring.filmes.dto.request.RequestDiretorDTO;
import com.api.spring.filmes.dto.response.DiretorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DiretorConverter implements CrudConverter<Diretor, DiretorDTO, RequestDiretorDTO> {

    @Autowired
    FilmeConverter filmeConverter;

    @Override
    public DiretorDTO entidadeParaDto(Diretor entidade) {

        if (Objects.isNull(entidade)) {
            return null;
        }
        return new DiretorDTO(entidade.getId(), entidade.getNome(), entidade.getCreatedAt(), entidade.getUpdatedAt());
    }

    @Override
    public Diretor dtoCadastroParaEntidade(RequestDiretorDTO dto) {
        var diretor = new Diretor();
        diretor.setNome(dto.getNome());
        return diretor;
    }

}