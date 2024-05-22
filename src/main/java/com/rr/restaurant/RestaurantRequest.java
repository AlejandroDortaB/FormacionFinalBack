package com.rr.restaurant;

public class RestaurantRequest {
	private String name;
	private Integer capacity;
	private String description;
    private Integer userId;
    private boolean enable;

    public RestaurantRequest(String name, Integer capacity, String description, Integer userId,boolean enable) {
        this.name = name;
        this.capacity = capacity;
        this.description = description;
        this.userId = userId;
        this.enable = enable;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
   
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public boolean isEnable() {
        return enable;
    }
    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    
    
}
