package com.api.spring.filmes.core.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

public abstract class CrudController<ENTITY, ID> {
    @Autowired
    protected CrudService<ENTITY, ID> service;

    @GetMapping
    public ResponseEntity<List<ENTITY>> listarTodos(){

        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ENTITY> listarUm(@PathVariable("id") ID id){

        ENTITY entity = service.porId(id);

        if(Objects.isNull(entity)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(entity);
    }

    @PostMapping
    public ResponseEntity<ENTITY> criar(@RequestBody ENTITY entity){
            ENTITY entitySave = service.criar(entity);
            return ResponseEntity.ok(entitySave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ENTITY> editar(@RequestBody ENTITY entity, @PathVariable("id") ID id){
        ENTITY entityEditar = service.editar(id, entity);
        return ResponseEntity.ok(entityEditar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") ID id){
        service.excluir(id);
        return ResponseEntity.ok().build();
    }

}
