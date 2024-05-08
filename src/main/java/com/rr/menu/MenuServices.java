package com.rr.menu;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rr.base.BaseService;
import com.rr.plates.FoodPlates;
import com.rr.plates.FoodPlatesRepository;
import com.rr.restaurant.Restaurant;
import com.rr.restaurant.RestaurantRepository;


@Service
public class MenuServices extends BaseService<Menu, MenuRepository>{

	RestaurantRepository restaurantRepository;
	FoodPlatesRepository foodPlatesRepository;

	public MenuServices(MenuRepository repository, RestaurantRepository restaurantRepository,FoodPlatesRepository foodPlatesRepository) {
		super(repository);
		this.restaurantRepository = restaurantRepository;
		this.foodPlatesRepository = foodPlatesRepository;
	}

	
	public ResponseEntity<Menu> create(MenuRequest request) {
		Optional<Restaurant> opRestaurant= this.restaurantRepository.findById(request.getRestaurant());
		if(opRestaurant.isPresent()){
			 Menu menu = new Menu(request.getName(), opRestaurant.get());
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(menu));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

	public ResponseEntity< Map<String, String>> update(Integer id, MenuRequest request) {
        Optional<Menu> optionalMenu = repository.findById(id);
        Map<String, String> response = new HashMap<>();
        if (optionalMenu.isPresent()) {
            Menu existingEntity = optionalMenu.get();
			if(request.getRestaurant() != null){//Cambio del Restaurante
				Optional<Restaurant> optionalRestaurant = this.restaurantRepository.findById(request.getRestaurant());
				if(optionalRestaurant.isPresent()){
					existingEntity.setRestaurant(optionalRestaurant.get());
				}
			}
			if(request.getName()!=null){//cambio del Nombre
				existingEntity.setName(request.getName());
			}

           repository.save(existingEntity);
           response.put("message", "modificado exitosamente");

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } 
        response.put("message", "No se ha podido modificar");
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(response);
    } 
	

}
