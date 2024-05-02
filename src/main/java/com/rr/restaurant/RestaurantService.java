package com.rr.restaurant;

import org.springframework.stereotype.Service;

import com.rr.base.BaseService;

@Service
public class RestaurantService extends BaseService<Restaurant, RestaurantRepository>  {

	public RestaurantService(RestaurantRepository repository) {
		super(repository);
	}

}
