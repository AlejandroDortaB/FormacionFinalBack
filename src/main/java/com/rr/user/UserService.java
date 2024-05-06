package com.rr.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rr.base.BaseService;
import com.rr.reservation.Reservation;
import com.rr.reservation.ReservationRepository;


@Service
public class UserService extends BaseService<User, UserRepository> {

	private ReservationRepository reservationRepository;

	public UserService(UserRepository repository,ReservationRepository reservationRepository) {
		super(repository);
		this.reservationRepository=reservationRepository;
	}

    public ResponseEntity<List<Reservation>> getUserReservation(Integer userId) {
		return ResponseEntity.status(HttpStatus.OK).body(this.reservationRepository.findByUserId(userId));
    }

}
