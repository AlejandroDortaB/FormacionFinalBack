package com.rr.base;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


public abstract class BaseController<E, S extends BaseService<E, ?>> {

    protected S service;

    public BaseController(S service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<E>> getAll() {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<E> getOne(@PathVariable Integer id) {
        return service.getById(id);
    }

    /* @PostMapping
    public ResponseEntity<E> create(@RequestBody E entity) {
        return service.create(entity);
    } */

    @PutMapping("/{id}")
    public ResponseEntity< Map<String, String>> update(@PathVariable Integer id, @RequestBody E entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Integer id) {
        return service.delete(id);
    }
}


