package com.rr.menu;

import java.util.List;

public class MenuRequest {
    private Integer id;
    private String name;
    private Integer restaurant;


    
    public MenuRequest(Integer id, String name, Integer restaurant) {
        this.id = id;
        this.name = name;
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
    public Integer getRestaurant() {
        return restaurant;
    }
    public void setRestaurant(Integer restaurant) {
        this.restaurant = restaurant;
    }
   
 /*   public List<FoodPlates> generateFoodPlates() {
    List<FoodPlates> aux = new ArrayList<>();

    for (Integer i = 0; i < this.foodPlatesIds.size(); i++) {
        Optional<FoodPlates> optFood = this.foodPlatesRepository.findById(this.foodPlatesIds.get(i));
        if (optFood.isPresent()) {
            aux.add(optFood.get());
        }
    }

    return aux;
} */
    
}
