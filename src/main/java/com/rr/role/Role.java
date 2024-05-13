package com.rr.role;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rr.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Role {

    @Id
	@GeneratedValue
	private Integer id;
    private String name;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private List<User> user;

    public Role() {
    }
    
    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Role(Integer id, String name, List<User> user) {
        this.id = id;
        this.name = name;
        this.user = user;
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

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    } 
    
    
}
