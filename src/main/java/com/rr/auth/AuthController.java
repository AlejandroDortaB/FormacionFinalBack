package com.rr.auth;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//Controlador parte publica
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private AuthService auth_service;
	
	
	public AuthController(AuthService auth_service){
		this.auth_service=auth_service;
	}
	
	@PostMapping(value="login")
	public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest body) {
		return this.auth_service.LoginUser(body);
	}
	
	@PostMapping(value="register")
	public  ResponseEntity<Map<String, String>> register(@RequestBody RegisterRequest body) {
		return this.auth_service.registerUser(body);
	}


}
