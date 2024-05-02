package com.rr.user;

import java.util.Collection;
import java.util.List;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rr.reservation.Reservation;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



@Entity
public class User implements UserDetails{
	@Id
	@GeneratedValue
	private Integer id;
	private String username; 
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	@JsonManagedReference
	private List<Reservation> reservations;
	
	
	public User() {}

	
	public User(Integer id) {
		this.id = id;
	}


	public User(String username, String password) {
		this.username=username;
		this.password=password;
	}
	public User(String username, String password, List<Reservation> reservations) {
		this.username = username;
		this.password = password;
		this.reservations = reservations;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}
	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	} 
	
	  public void hashPassword() {
	        // Utilizar BCryptPasswordEncoder para hashear la contraseña
	        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	        this.password= encoder.encode(this.password);
	    }
	  
	  public List<Reservation> getReservations() {
			return this.reservations;
		}
	  
	  public void setReservations(List<Reservation> reservations) {
			this.reservations=reservations;
		}
	
	  

}
