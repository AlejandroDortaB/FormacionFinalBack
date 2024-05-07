package com.rr.plates;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rr.base.BaseService;
import com.rr.menu.Menu;
import com.rr.menu.MenuRepository;

@Service
public class FoodPlatesServices extends BaseService<FoodPlates, FoodPlatesRepository>{
    MenuRepository menuRepository;

    public FoodPlatesServices(FoodPlatesRepository repository,MenuRepository menuRepository) {
        super(repository);
        this.menuRepository = menuRepository;
    }

    public ResponseEntity<FoodPlates> create(FoodPlatesRequest request) {
		Optional<Menu> opMenu= this.menuRepository.findById(request.getMenuId());
		if(opMenu.isPresent()){
			FoodPlates foodPlates= new FoodPlates(request.getName(),request.getIngredients(),request.getPrices(),opMenu.get());
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(foodPlates));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        
    }

}
