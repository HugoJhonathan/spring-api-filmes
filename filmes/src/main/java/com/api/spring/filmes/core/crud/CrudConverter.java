package com.api.spring.filmes.core.crud;

public interface CrudConverter<E, DTO, DTOCAD> {
    DTO entidadeParaDto(E entidade);
    E dtoCadastroParaEntidade(DTOCAD dto);

}
