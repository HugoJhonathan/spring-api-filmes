package com.api.spring.filmes.core.crud.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id){

        super("Resource not found! id: "+id);
    }
}
