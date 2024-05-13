package com.rr.auth;

import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rr.jwt.JwtService;
import com.rr.role.Role;
import com.rr.role.RoleRepository;
import com.rr.user.User;
import com.rr.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JwtService jwtservice;

	@Autowired
	private RoleRepository roleRepository;
	
	public AuthService(UserRepository userRepository,JwtService jwtservice,RoleRepository roleRepository) {
		this.userRepository=userRepository;
		this.jwtservice = jwtservice;
		this.roleRepository=roleRepository;
	}
	
	

	public ResponseEntity<Map<String, String>> registerUser(RegisterRequest body) {
		Map<String, String> result = new HashMap<String, String>();
		
		User existingUser = userRepository.findByUsername(body.getUsername());
	    if (existingUser != null) {
	        result.put("error", "El nombre de usuario ya está en uso");
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	    }
	    	Role role= this.roleRepository.findById(1).get();
			User user =  new User(body.getUsername(),body.getPassword(),role);
			
			
			if(user != null) {
				user.hashPassword();
				result.put("status","registrado con exito");
				this.userRepository.save(user);
				return ResponseEntity.status(HttpStatus.CREATED).body(result);  
			}
			result.put("error","Error al crear el usuario");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		
		
	}

	public ResponseEntity<Map<String, String>> LoginUser(LoginRequest body) {
		 User user=(User) userRepository.findByUsername(body.getUsername());
		 Map<String, String> result = new HashMap<String, String>();
		 if(user != null) {
			 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			 if (encoder.matches(body.getPassword(), user.getPassword())) {
		            System.out.println("Contraseña correcta");
		            result.put("token",this.jwtservice.getToken(user));
		            return ResponseEntity.status(HttpStatus.OK).body(result);
		        } else {
		            result.put("error","Contraseña incorrecta");
		   		 	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		        }
		 }
		 result.put("error","Error al hacer login");
		 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}
}
