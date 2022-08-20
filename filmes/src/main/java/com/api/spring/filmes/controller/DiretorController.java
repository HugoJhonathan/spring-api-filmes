package com.api.spring.filmes.controller;

import com.api.spring.filmes.converter.FilmeConverter;
import com.api.spring.filmes.core.crud.CrudController;
import com.api.spring.filmes.domain.Diretor;
import com.api.spring.filmes.dto.request.RequestDiretorDTO;
import com.api.spring.filmes.dto.response.DiretorDTO;
import com.api.spring.filmes.dto.response.FilmeDTO;
import com.api.spring.filmes.repository.DiretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/diretores")
public class DiretorController extends CrudController<Diretor, DiretorDTO, RequestDiretorDTO, Long> {

    @Autowired
    private DiretorRepository diretorRepository;

    @Autowired
    private FilmeConverter filmeConverter;

    @GetMapping("/{id}/filmes")
    public ResponseEntity<List<FilmeDTO>> listarFilmes(@PathVariable(value = "id") Long idGen){

        var filmes = diretorRepository.recuperarPorIds(idGen)
                .stream().map(filmeConverter::entidadeParaDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(filmes);
    }
}