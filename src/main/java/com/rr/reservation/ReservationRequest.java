package com.rr.reservation;

import java.sql.Date;
import java.sql.Time;

import com.rr.restaurant.Restaurant;
import com.rr.user.User;

public class ReservationRequest {
    private Integer id;
	private Date date;
	private Time time;
	private Integer numberPeople;
    private Integer restaurant;
    private Integer user;

    
    public ReservationRequest(Integer id, Date date, Time time, Integer numberPeople, Integer restaurant,
            Integer user) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.numberPeople = numberPeople;
        this.restaurant = restaurant;
        this.user = user;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Time getTime() {
        return time;
    }
    public void setTime(Time time) {
        this.time = time;
    }
    public Integer getNumberPeople() {
        return numberPeople;
    }
    public void setNumberPeople(Integer numberPeople) {
        this.numberPeople = numberPeople;
    }
    public Integer getRestaurant() {
        return restaurant;
    }
    public void setRestaurant(Integer restaurant) {
        this.restaurant = restaurant;
    }
    public Integer getUser() {
        return user;
    }
    public void setUser(Integer user) {
        this.user = user;
    }

    
}
