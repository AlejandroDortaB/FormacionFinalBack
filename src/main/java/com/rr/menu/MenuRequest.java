package com.rr.menu;

import java.util.List;

public class MenuRequest {
    private Integer id;
    private String name;
	private List<String> foodPlates;
    private Integer restaurant;

    
    public MenuRequest(Integer id, String name, List<String> foodPlates, Integer restaurant) {
        this.id = id;
        this.name = name;
        this.foodPlates = foodPlates;
        this.restaurant = restaurant;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<String> getFoodPlates() {
        return foodPlates;
    }
    public void setFoodPlates(List<String> foodPlates) {
        this.foodPlates = foodPlates;
    }
    public Integer getRestaurant() {
        return restaurant;
    }
    public void setRestaurant(Integer restaurant) {
        this.restaurant = restaurant;
    }
   
    
}
