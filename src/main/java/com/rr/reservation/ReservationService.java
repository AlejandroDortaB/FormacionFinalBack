package com.rr.reservation;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rr.base.BaseService;
import com.rr.menu.Menu;
import com.rr.menu.MenuRequest;
import com.rr.restaurant.Restaurant;
import com.rr.restaurant.RestaurantRepository;
import com.rr.user.User;
import com.rr.user.UserRepository;


@Service
public class ReservationService extends BaseService<Reservation, ReservationRepository>{

	RestaurantRepository restaurantRepository;
	UserRepository userRespository;
	public ReservationService(ReservationRepository repository,RestaurantRepository restaurantRepository,UserRepository userRespository) {
		super(repository);
		this.restaurantRepository=restaurantRepository;
		this.userRespository=userRespository;
	}

	public ResponseEntity<Reservation> create(ReservationRequest request) {
		Optional<Restaurant> opRestaurant= this.restaurantRepository.findById(request.getRestaurant());
		Optional<User>	opUser=this.userRespository.findById(request.getUser());
		if(opRestaurant.isPresent() && opUser.isPresent()){
			Reservation reservation = new Reservation(request.getDate(),request.getTime(),request.getNumberPeople(),
			opRestaurant.get(),opUser.get());
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(reservation));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        
    }

}
