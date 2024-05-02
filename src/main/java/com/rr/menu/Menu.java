package com.rr.menu;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rr.restaurant.Restaurant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Menu {
	@Id
	@GeneratedValue
	private Integer id;
	private List<String> foodPlates;

	@ManyToOne
	@JsonBackReference
	private Restaurant restaurant;
	
		
	public Menu() {
    }


    public Menu(Integer id) {
		this.id = id;
	}


	public Menu(List<String> foodPlates, Restaurant restaurant) {
		this.foodPlates = foodPlates;
		this.restaurant = restaurant;
	}

	public Integer getId() {
		return id;
	}

	
	public List<String> getFoodPlates() {
		return foodPlates;
	}
	public void setFoodPlates(List<String> foodPlates) {
		this.foodPlates = foodPlates;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}
	
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant=restaurant;
	}

	

	
	
}
