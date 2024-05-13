package com.rr.user;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rr.base.BaseController;
import com.rr.reservation.Reservation;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("user")
public class UserController extends BaseController<User, UserService> {

	public UserController(UserService service) {
		super(service);
	}

	@GetMapping("{id}/reservations")
    public ResponseEntity<List<Reservation>> getUserReservation(@PathVariable Integer id) {
        return service.getUserReservation(id);
    }

	@PutMapping("{idUser}/role/{roleId}")
    public ResponseEntity<User> modifyUserRole(@PathVariable Integer idUser, @PathVariable Integer roleId ) {
        return service.modifyUserRole(idUser,roleId);
    }

}
