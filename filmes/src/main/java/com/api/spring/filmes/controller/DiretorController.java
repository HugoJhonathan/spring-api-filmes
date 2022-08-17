package com.api.spring.filmes.controller;

import com.api.spring.filmes.core.crud.CrudController;
import com.api.spring.filmes.domain.Diretor;
import com.api.spring.filmes.dto.request.RequestDiretorDTO;
import com.api.spring.filmes.dto.response.DiretorDTO;
import com.api.spring.filmes.dto.response.full.DiretorFullDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diretores")
public class DiretorController extends CrudController<Diretor, DiretorDTO, DiretorFullDTO, RequestDiretorDTO, Long> {

}