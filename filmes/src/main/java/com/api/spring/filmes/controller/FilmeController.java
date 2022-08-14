package com.api.spring.filmes.controller;

import com.api.spring.filmes.core.crud.CrudController;
import com.api.spring.filmes.domain.Filme;
import com.api.spring.filmes.dto.FilmeDTO;
import com.api.spring.filmes.dto.full.FilmeFullDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmes")
public class FilmeController extends CrudController<Filme, FilmeDTO, FilmeFullDTO, Long> {

}

