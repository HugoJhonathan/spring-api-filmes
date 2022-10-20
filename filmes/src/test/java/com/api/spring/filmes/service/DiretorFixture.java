package com.api.spring.filmes.service;

import com.api.spring.filmes.domain.Diretor;

public class DiretorFixture {

    public static Diretor criar(){
        Diretor diretor = new Diretor();
        diretor.setNome("Diretor 1");
        diretor.setId(1L);

        return diretor;
    }
}
