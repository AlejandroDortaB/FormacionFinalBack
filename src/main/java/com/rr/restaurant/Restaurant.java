package com.rr.restaurant;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/restaurant")
public class Restaurant {
	
	@PostMapping(value="test")
	public ResponseEntity<Map<String, String>> test() {
		Map<String, String> result = new HashMap<String, String>();
		result.put("status","La peticion funciona correctamente");
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

}
