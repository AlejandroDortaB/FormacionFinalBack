package com.rr.conversation;

import java.util.List;

import com.rr.message.message;
import com.rr.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Conversation {
    @Id
	@GeneratedValue
	private Integer id;

    @ManyToMany
    List<User> users;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conversation")
    List<message> menssages;
    

    public Conversation() {
    }
    

    public Conversation(List<User> users) {
        this.users = users;
    }


    public Conversation(Integer id, List<User> users, List<message> menssages) {
        this.id = id;
        this.users = users;
        this.menssages = menssages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<message> getMenssages() {
        return menssages;
    }

    public void setMenssages(List<message> menssages) {
        this.menssages = menssages;
    }


    
}
