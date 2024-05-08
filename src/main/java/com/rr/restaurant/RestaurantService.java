package com.rr.restaurant;

import java.util.Optional;
import org.springframework.beans.BeanUtils;
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

    public ResponseEntity<Restaurant> update(Integer id, Restaurant request) {
		Optional<Restaurant> optionalrestaurant = repository.findById(id);
		if(optionalrestaurant.isPresent()){
			Restaurant restaurant=optionalrestaurant.get();
			BeanUtils.copyProperties(request, restaurant);//copia las propiedades de (A en B)
			repository.save(restaurant);
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(restaurant));
		}
		return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
	
    }

}
