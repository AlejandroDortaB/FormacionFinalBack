package com.rr.restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rr.base.BaseController;
import com.rr.reservation.Reservation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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

	@PutMapping("/{id}")
    public ResponseEntity<Restaurant> update(@PathVariable Integer id, @RequestBody Restaurant request) {
        return service.update(id, request);
    }
    @GetMapping("/{id}/reservation")
    public ResponseEntity<List<Reservation>> getTotalReservations(@PathVariable Integer id) {
        return service.getTotalReservations(id);
    }

    @GetMapping("/{id}/reservation/group-date")
    public ResponseEntity<List<Object[]>> getTotalReservationsByRestaurantId(@PathVariable Integer id) {
        return service.getTotalReservationsByRestaurantId(id);
    }
    

}
