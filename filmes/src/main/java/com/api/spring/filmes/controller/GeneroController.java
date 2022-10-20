package com.api.spring.filmes.controller;

import com.api.spring.filmes.converter.FilmeConverter;
import com.api.spring.filmes.converter.GeneroConverter;
import com.api.spring.filmes.core.crud.CrudController;
import com.api.spring.filmes.domain.Genero;
import com.api.spring.filmes.dto.request.RequestGeneroDTO;
import com.api.spring.filmes.dto.response.GeneroDTO;
import com.api.spring.filmes.dto.response.full.GeneroFullDTO;
import com.api.spring.filmes.repository.GeneroRepository;
import com.api.spring.filmes.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/generos")
public class GeneroController extends CrudController<Genero, GeneroDTO, RequestGeneroDTO, Long> {

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private GeneroService generoService;

    @Autowired
    private GeneroConverter generoConverter;

    @Autowired
    private FilmeConverter filmeConverter;

    @GetMapping("/{id}/filmes")
    public ResponseEntity<GeneroFullDTO> listarFilmes(@PathVariable(value = "id") Long idGen){

        var filmes = generoRepository.filmesDoGenero(idGen)
                .stream().map(filmeConverter::entidadeParaDto)
                .collect(Collectors.toList());

        var genero = generoConverter.entidadeParaDto(generoService.porId(idGen));
        var generoFull = new GeneroFullDTO(genero, filmes);

        return ResponseEntity.ok(generoFull);
    }
}