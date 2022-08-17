package com.api.spring.filmes.core.crud;

public interface CrudConverter<E, DTO, DTOF, DTOCAD> {
    DTO entidadeParaDto(E entidade); // dto de resposta que NÃO mostra objetos filhos
    DTOF entidadeParaDtoFull(E entidade); // dto de resposta que mostra objetos filhos
    E dtoParaEntidade(DTO dto);
    E dtoCadastroParaEntidade(DTOCAD dto); // dto para CADASTRO

}
