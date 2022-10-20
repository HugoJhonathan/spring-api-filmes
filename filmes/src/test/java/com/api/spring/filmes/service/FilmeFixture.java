package com.api.spring.filmes.service;

import com.api.spring.filmes.domain.Filme;
import com.api.spring.filmes.domain.Genero;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class FilmeFixture {



    public static Filme criar(){
        Filme filme = new Filme();
        Genero genero = new Genero("Genero1");
        genero.setId(1L);
//        filme.setId(1L);
        filme.setTitle("Titulo");
        filme.setDiretor(DiretorFixture.criar());
        Set<Genero> generos = new HashSet<>(Arrays.asList(genero));
        filme.setGeneros(generos);
        filme.setReceita(233.00);
        filme.setData(new Date());
        filme.setPoster("Poster");
        filme.setOrcamento(66.66);



        return filme;
    }
}
