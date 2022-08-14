package com.api.spring.filmes.core.crud;

public interface CrudConverter<E, DTO, DTOF> {
    DTO entidadeParaDto(E entidade);
    DTOF entidadeParaDtoFull(E entidade);
    E dtoParaEntidade(DTO dto);

}
