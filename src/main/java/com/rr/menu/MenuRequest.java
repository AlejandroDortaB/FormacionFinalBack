package com.rr.menu;

import java.util.List;

import com.rr.plates.FoodPlatesRepository;

public class MenuRequest {
    private Integer id;
    private String name;
	private List<Integer> foodPlatesIds;
    private Integer restaurant;

    FoodPlatesRepository foodPlatesRepository;

    
    public MenuRequest(Integer id, String name, List<Integer> foodPlatesIds, Integer restaurant,FoodPlatesRepository foodPlatesRepository) {
        this.id = id;
        this.name = name;
        this.foodPlatesIds = foodPlatesIds;
        this.restaurant = restaurant;
        this.foodPlatesRepository = foodPlatesRepository;
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
    public List<Integer> getFoodPlatesId() {
        return foodPlatesIds;
    }
    public void setFoodPlates(List<Integer> foodPlatesIds) {
        this.foodPlatesIds = foodPlatesIds;
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
