package com.rr.user;

import java.util.List;
import java.util.Optional;

import org.springframework.core.Conventions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rr.base.BaseService;
import com.rr.reservation.Reservation;
import com.rr.reservation.ReservationRepository;
import com.rr.restaurant.Restaurant;
import com.rr.restaurant.RestaurantRepository;
import com.rr.role.Role;
import com.rr.role.RoleRepository;
import com.rr.conversation.Conversation;

@Service
public class UserService extends BaseService<User, UserRepository> {

	private ReservationRepository reservationRepository;
	private RoleRepository roleRepository;
	private RestaurantRepository restaurantRespository;

	public UserService(UserRepository repository,ReservationRepository reservationRepository,
	RoleRepository roleRepository,RestaurantRepository restaurantRespository) {
		super(repository);
		this.reservationRepository=reservationRepository;
		this.roleRepository=roleRepository;
		this.restaurantRespository=restaurantRespository;
	}

    public ResponseEntity<List<Reservation>> getUserReservation(Integer userId) {
		return ResponseEntity.status(HttpStatus.OK).body(this.reservationRepository.findByUserId(userId));
    }

	public ResponseEntity<User> modifyUserRole(Integer userId,Integer roleId) {
 		Optional<User> userOpt = repository.findById(userId);
		if(userOpt.isPresent()){
			Optional<Role> roleOpt = roleRepository.findById(roleId);
			if(roleOpt.isPresent()){
				User user= userOpt.get();
				user.setRole(roleOpt.get());
				this.repository.save(user);
				return ResponseEntity.status(HttpStatus.OK).body(user);
			}
		}
		
		return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
    }

    public ResponseEntity<List<Conversation>> getUserConversations(Integer userId) {
        Optional<User> userOpt= this.repository.findById(userId);
		if(userOpt.isPresent()){
			User user= userOpt.get();
			return ResponseEntity.status(HttpStatus.OK).body(user.getConversations());
		}
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    public ResponseEntity<List<Restaurant>> getUserRestaurants(Integer userId) {
		return ResponseEntity.status(HttpStatus.OK).body(restaurantRespository.findByUserId(userId));
    }


}
