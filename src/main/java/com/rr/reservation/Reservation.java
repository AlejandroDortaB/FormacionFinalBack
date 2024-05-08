package com.rr.reservation;

import java.sql.Date;
import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rr.restaurant.Restaurant;
import com.rr.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Reservation {

	@Id
	@GeneratedValue
	private Integer id;
	private Date date;
	private Time time;
	private Integer numberPeople;
	
	@ManyToOne
	@JsonIgnore
	private Restaurant restaurant;
	
	@ManyToOne
	@JsonIgnore
	private User user;
	
	
	
	public Reservation() {
	}

	

	public Reservation(Date date, Time time, Integer numberPeople, Restaurant restaurant, User user) {
		this.date = date;
		this.time = time;
		this.numberPeople = numberPeople;
		this.restaurant = restaurant;
		this.user = user;
	}

	public Integer getId() {
		return id;
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
	
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
