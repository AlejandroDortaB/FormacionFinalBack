package com.rr.menu;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rr.base.BaseController;
import com.rr.restaurant.Restaurant;
import com.rr.restaurant.RestaurantService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/menu")
public class MenuController extends BaseController<Menu, MenuServices> {

	public MenuController(MenuServices service) {
		super(service);
		
	}

}
