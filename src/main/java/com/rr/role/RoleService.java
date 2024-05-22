package com.rr.role;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rr.base.BaseService;
import com.rr.user.User;
import com.rr.user.UserRepository;

@Service
public class RoleService extends BaseService<Role, RoleRepository>{

    UserRepository userRepository;

    public RoleService(RoleRepository repository,UserRepository userRepository) {
        super(repository);
        this.userRepository = userRepository;
    }

    public ResponseEntity<Role> create(Role entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(entity));
    }

    public ResponseEntity<List<User>> getAllUsersByRole(Integer roleId) {
        return ResponseEntity.status(HttpStatus.OK).body(this.userRepository.findByRoleId(roleId));
    }

}
