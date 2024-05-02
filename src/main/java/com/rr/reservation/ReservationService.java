package com.rr.reservation;

import org.springframework.stereotype.Service;

import com.rr.base.BaseService;


@Service
public class ReservationService extends BaseService<Reservation, ReservationRepository>{

	public ReservationService(ReservationRepository repository) {
		super(repository);
	
	}

}
