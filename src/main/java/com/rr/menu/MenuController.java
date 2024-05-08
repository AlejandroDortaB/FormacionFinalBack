package com.rr.menu;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rr.base.BaseController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("menu")
public class MenuController extends BaseController<Menu, MenuServices> {

	public MenuController(MenuServices service) {
		super(service);
	}

	@PostMapping
    public ResponseEntity<Menu> create(@RequestBody MenuRequest entity) {
        return service.create(entity);
    }

	@PutMapping("/{id}")
    public ResponseEntity< Map<String, String>> update(@PathVariable Integer id, @RequestBody MenuRequest request) {
        return service.update(id, request);
    }

}
