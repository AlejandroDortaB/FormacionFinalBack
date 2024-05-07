package com.rr.menu;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rr.plates.FoodPlates;
import com.rr.restaurant.Restaurant;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Menu {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "menu")
	private List<FoodPlates> foodPlates;

	@ManyToOne
	@JsonIgnore
	private Restaurant restaurant;
	
		
	public Menu() {
    }


    public Menu(Integer id) {
		this.id = id;
	}
	public Menu(String name, Restaurant restaurant) {
		this.restaurant = restaurant;
		this.name = name;
	}

	public Menu(String name,List<FoodPlates> foodPlates, Restaurant restaurant) {
		this.foodPlates = foodPlates;
		this.restaurant = restaurant;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	
	public List<FoodPlates> getFoodPlates() {
		return foodPlates;
	}
	public void setFoodPlates(List<FoodPlates> foodPlates) {
		this.foodPlates = foodPlates;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}
	
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant=restaurant;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

}
