package com.rr.reservation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rr.base.BaseController;
import com.rr.menu.Menu;
import com.rr.menu.MenuRequest;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController extends BaseController<Reservation, ReservationService>{

	public ReservationController(ReservationService service) {
		super(service);
		
	}
	@PostMapping
    public ResponseEntity<Reservation> create(@RequestBody ReservationRequest request) {
		
        return service.create(request);
    }

}
