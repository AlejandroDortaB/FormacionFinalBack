package com.rr.restaurant;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rr.base.BaseController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("restaurant")
public class RestaurantController  extends BaseController<Restaurant, RestaurantService> {
	
	public RestaurantController(RestaurantService service) {
		super(service);
	}

	@PostMapping
    public ResponseEntity<Restaurant> create(@RequestBody Restaurant entity) {
        return service.create(entity);
    }

	@PostMapping(value="test")
	public ResponseEntity<Map<String, String>> test() {
		Map<String, String> result = new HashMap<String, String>();
		result.put("status","La peticion funciona correctamente");
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

}
