package com.rr.role;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rr.base.BaseController;
import com.rr.user.User;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("role")
public class RoleController extends BaseController<Role, RoleService>{

    public RoleController(RoleService service) {
        super(service);
    }
    @GetMapping("{roleId}/users")
    public  ResponseEntity<List<User>>  getUserConversations(@PathVariable Integer roleId) {
        return service.getAllUsersByRole(roleId);
    }

    @PostMapping
    public ResponseEntity<Role> create(@RequestBody Role entity) {
        return service.create(entity);
    }

}
