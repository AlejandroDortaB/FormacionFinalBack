package com.rr.restaurant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rr.base.BaseService;

@Service
public class RestaurantService extends BaseService<Restaurant, RestaurantRepository>  {

	public RestaurantService(RestaurantRepository repository) {
		super(repository);
	}

	public ResponseEntity<Restaurant> create(Restaurant entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(entity));
    }

}
