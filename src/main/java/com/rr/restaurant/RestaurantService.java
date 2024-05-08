package com.rr.restaurant;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rr.base.BaseService;
import com.rr.reservation.Reservation;
import com.rr.reservation.ReservationRepository;

@Service
public class RestaurantService extends BaseService<Restaurant, RestaurantRepository>  {

	ReservationRepository reservationRepository;

	public RestaurantService(RestaurantRepository repository,ReservationRepository reservationRepository) {
		super(repository);
		this.reservationRepository = reservationRepository;
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
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(restaurant));
		}
		return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
    }

	public ResponseEntity<List<Object[]>> getTotalReservationsByRestaurantId(Integer restaurantId){
		List<Object[]> results= this.reservationRepository.findTotalReservationsByRestaurantId(restaurantId);
		System.out.println(results);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	public ResponseEntity<List<Reservation>> getTotalReservations(Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.reservationRepository.findByRestaurantId(id));
	}

}
