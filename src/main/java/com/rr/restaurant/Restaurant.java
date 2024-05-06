package com.rr.restaurant;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rr.menu.Menu;
import com.rr.reservation.Reservation;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Integer capacity;
	private String description;
	private Integer imgIndex;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
	private List<Menu> menus;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
	@JsonIgnore
	private List<Reservation> reservations;
	
	public Restaurant() {}

	public Restaurant(Integer id) {
        this.id = id;
    }
	
	public Restaurant(Integer id,String name,Integer imgIndex) {
		this.id=id;
		this.name= name;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Restaurant(String name, Integer capacity, String description, List<Menu> menus,
			List<Reservation> reservations) {
		this.name = name;
		this.capacity = capacity;
		this.description = description;
		this.menus = menus;
		this.reservations = reservations;
	}

	public Integer getImgIndex() {
		return imgIndex;
	}

	public void setImgIndex(Integer imgIndex) {
		this.imgIndex = imgIndex;
	}
	
}
