package com.api.spring.filmes.core.crud;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Api("API Rest Filmes")
@CrossOrigin(origins = "*")
public abstract class CrudController<E extends CrudDomain<ID>, DTO, DTOCAD, ID> {

    @Autowired
    protected CrudService<E, ID> service;

    @Autowired
    protected CrudConverter<E, DTO, DTOCAD> converter;

    @GetMapping
    @ApiOperation(value = "List all resorces")
    public ResponseEntity<List<DTO>> listarTodos(@RequestParam(value = "search", required = false) String param) {

        if (!Objects.isNull(param)) {
            List<DTO> diretores = service.findByNomeStartingWith(param)
                    .stream()
                    .map(converter::entidadeParaDto)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(diretores);
        }

        List<DTO> diretores = service.listar()
                .stream()
                .map(converter::entidadeParaDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(diretores);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Return specific resource")
    public ResponseEntity<DTO> listarUm(@PathVariable("id") ID id) {

        E entity = service.porId(id);

        if (Objects.isNull(entity)) {
            return ResponseEntity.notFound().build();
        }
        DTO convertido = converter.entidadeParaDto(entity);
        return ResponseEntity.ok(convertido);
    }

    @PostMapping
    @ApiOperation(value = "Create a new resorce")
    public ResponseEntity<DTO> criar(@RequestBody @Valid DTOCAD dto) {

        E entity = converter.dtoCadastroParaEntidade(dto);
        E entitySaved = service.criar(entity);
        DTO dtoSaved = converter.entidadeParaDto(entitySaved);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entitySaved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(dtoSaved);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Edit specific resorce")
    public ResponseEntity<DTO> editar(@RequestBody DTOCAD dto, @PathVariable("id") ID id) {

        E entity = converter.dtoCadastroParaEntidade(dto);
        E entitySaved = service.editar(id, entity);
        DTO dtoSaved = converter.entidadeParaDto(entitySaved);

        return ResponseEntity.ok(dtoSaved);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete specific resorce")
    public ResponseEntity<Void> deletar(@PathVariable("id") ID id) {

        service.excluir(id);

        return ResponseEntity.noContent().build();
    }

}
