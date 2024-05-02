package com.rr.reservation;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rr.base.BaseController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController extends BaseController<Reservation, ReservationService>{

	public ReservationController(ReservationService service) {
		super(service);
		
	}

}
