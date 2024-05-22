package com.rr.user;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	 User findByUsername(String username); 

	 List<User> findByRoleId(Integer roleId); 
	
}
