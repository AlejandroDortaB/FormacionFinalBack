package com.rr.menu;



import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rr.base.BaseService;
import com.rr.restaurant.Restaurant;
import com.rr.restaurant.RestaurantRepository;


@Service
public class MenuServices extends BaseService<Menu, MenuRepository>{

	RestaurantRepository restaurantRepository;
	public MenuServices(MenuRepository repository, RestaurantRepository restaurantRepository) {
		super(repository);
		this.restaurantRepository = restaurantRepository;
	}

	
	public ResponseEntity<Menu> create(MenuRequest request) {
		Optional<Restaurant> opRestaurant= this.restaurantRepository.findById(request.getRestaurant());
		if(opRestaurant.isPresent()){
			 Menu menu = new Menu(request.getName(), request.getFoodPlates(), opRestaurant.get());
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(menu));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        
    }
	

}
