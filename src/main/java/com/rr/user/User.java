package com.rr.user;

import java.util.Collection;
import java.util.List;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rr.conversation.Conversation;
import com.rr.reservation.Reservation;
import com.rr.restaurant.Restaurant;
import com.rr.role.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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

	@ManyToOne
	private Role role;

	@ManyToMany
	@JsonIgnore
	private List<Conversation> conversations;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	@JsonManagedReference
	private List<Restaurant> restaurants;
	
	
	public User() {}

	
	public User(Integer id) {
		this.id = id;
	}


	public User(String username, String password) {
		this.username=username;
		this.password=password;
	}

	
	public User(String username, String password, Role role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}


	public User(String username, String password, List<Reservation> reservations) {
		this.username = username;
		this.password = password;
		this.reservations = reservations;
	}

	public User(Integer id, String username, String password, List<Reservation> reservations, Role role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.reservations = reservations;
		this.role = role;
	}


	public User(Integer id, String username, String password, List<Reservation> reservations, Role role,
			List<Conversation> conversations) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.reservations = reservations;
		this.role = role;
		this.conversations = conversations;
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


	public Integer getId() {
		return id;
	}


	public Role getRole() {
		return role;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public List<Conversation> getConversations() {
		return conversations;
	}


	public void setConversations(List<Conversation> conversations) {
		this.conversations = conversations;
	}
		
	
	  

}
