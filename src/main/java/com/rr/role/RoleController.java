package com.rr.role;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rr.base.BaseController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("role")
public class RoleController extends BaseController<Role, RoleService>{

    public RoleController(RoleService service) {
        super(service);
    }

    @PostMapping
    public ResponseEntity<Role> create(@RequestBody Role entity) {
        return service.create(entity);
    }

}
