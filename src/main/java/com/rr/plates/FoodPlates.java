package com.rr.plates;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rr.menu.Menu;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class FoodPlates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String ingredients;
    private Integer prices;

    @ManyToOne
    @JsonIgnore
    private Menu menu;
    

    public FoodPlates() {
    }
    public FoodPlates(String name, String ingredients, Integer prices, Menu menu) {
        this.name = name;
        this.ingredients = ingredients;
        this.prices = prices;
        this.menu=menu;
    }
    public FoodPlates(Integer id, String name, String ingredients, Integer prices, Menu menu) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.prices = prices;
        this.menu=menu;
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
    public Menu getMenu() {
        return menu;
    }
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
    
}
