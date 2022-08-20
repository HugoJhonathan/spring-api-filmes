package com.api.spring.filmes.controller;

import com.api.spring.filmes.converter.FilmeConverter;
import com.api.spring.filmes.core.crud.CrudController;
import com.api.spring.filmes.domain.Genero;
import com.api.spring.filmes.dto.request.RequestGeneroDTO;
import com.api.spring.filmes.dto.response.FilmeDTO;
import com.api.spring.filmes.dto.response.GeneroDTO;
import com.api.spring.filmes.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/generos")
public class GeneroController extends CrudController<Genero, GeneroDTO, RequestGeneroDTO, Long> {

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private FilmeConverter filmeConverter;

    @GetMapping("/{id}/filmes")
    public ResponseEntity<List<FilmeDTO>> listarFilmes(@PathVariable(value = "id") Long idGen){

        var filmes = generoRepository.recuperarPorIds(idGen)
                .stream().map(filmeConverter::entidadeParaDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(filmes);
    }
}