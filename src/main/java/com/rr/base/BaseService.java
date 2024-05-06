package com.rr.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public ResponseEntity< Map<String, String>> update(Integer id, E entity) {
        Optional<E> optionalEntity = repository.findById(id);
        Map<String, String> response = new HashMap<>();
        
        if (optionalEntity.isPresent()) {
            E existingEntity = optionalEntity.get();
            BeanUtils.copyProperties(entity, existingEntity);//copia las propiedades de (A en B)
           repository.save(existingEntity);
           response.put("message", "modificado exitosamente");

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } 
        response.put("message", "No se ha podido modificar");
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(response);
    }

    public ResponseEntity<Map<String, String>> delete(Integer id) {
         Map<String, String> response = new HashMap<>();
        try{
            repository.deleteById(id);
            response.put("message", "Borrado correctamente");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        catch(Exception exception){
            response.put("message", "error al borrar: " + exception.getMessage());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }
}