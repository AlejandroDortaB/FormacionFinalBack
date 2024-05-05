package com.rr.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public abstract class BaseService<E, R extends JpaRepository<E, Integer>> {

    protected R repository;

    public BaseService(R repository) {
        this.repository = repository;
    }

    public ResponseEntity<List<E>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    public ResponseEntity<E> getById(Integer id) {
        return  ResponseEntity.status(HttpStatus.OK).body(repository.findById(id).orElse(null));
    }

    /* public ResponseEntity<E> create(E entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(entity));
    } */

    public ResponseEntity<String> update(Integer id, E entity) {
        Optional<E> optionalEntity = repository.findById(id);
        
        if (optionalEntity.isPresent()) {
            E existingEntity = optionalEntity.get();
            BeanUtils.copyProperties(entity, existingEntity);//copia las propiedades de (A en B)
           repository.save(existingEntity);
            return ResponseEntity.status(HttpStatus.OK).body("modificado exitosamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("No se ha podido modificar");
    }

    public ResponseEntity<String> delete(Integer id) {
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Eliminado exitosamente");
    }
}