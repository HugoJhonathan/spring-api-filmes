package com.api.spring.filmes.controller;

import com.api.spring.filmes.core.crud.CrudController;
import com.api.spring.filmes.domain.Diretor;
import com.api.spring.filmes.dto.DiretorDTO;
import com.api.spring.filmes.dto.full.DiretorFullDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diretores")
public class DiretorController extends CrudController<Diretor, DiretorDTO, DiretorFullDTO, Long> {

}
