package com.rr.role;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rr.base.BaseService;

@Service
public class RoleService extends BaseService<Role, RoleRepository>{

    public RoleService(RoleRepository repository) {
        super(repository);
    }

    public ResponseEntity<Role> create(Role entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(entity));
    }

}
