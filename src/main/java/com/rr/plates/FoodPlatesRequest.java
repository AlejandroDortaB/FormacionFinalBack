package com.rr.plates;

public class FoodPlatesRequest {
    private Integer id;
    private String name;
    private String ingredients;
    private Integer prices;
    private Integer menuId;

    
    public FoodPlatesRequest(Integer id, String name, String ingredients, Integer prices, Integer menuId) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.prices = prices;
        this.menuId = menuId;
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
    public String getIngredients() {
        return ingredients;
    }
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    public Integer getPrices() {
        return prices;
    }
    public void setPrices(Integer prices) {
        this.prices = prices;
    }
    public Integer getMenuId() {
        return menuId;
    }
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    

}
