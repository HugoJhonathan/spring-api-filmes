package com.api.spring.filmes.controller;

import com.api.spring.filmes.core.crud.CrudController;
import com.api.spring.filmes.domain.Genero;
import com.api.spring.filmes.dto.GeneroDTO;
import com.api.spring.filmes.dto.full.GeneroFullDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generos")
public class GeneroController extends CrudController<Genero, GeneroDTO, GeneroFullDTO, Long> {

}
