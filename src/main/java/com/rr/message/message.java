package com.rr.message;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rr.conversation.Conversation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class message {

    @Id
	@GeneratedValue
	private Integer id;
    String text;
    boolean view;
    Integer emiterId;

    @ManyToOne
    @JsonIgnore
    Conversation conversation;
    
    public message() {
    }

    public message(String text, boolean view, Integer emiterId, Conversation conversation) {
        this.text = text;
        this.view = view;
        this.emiterId = emiterId;
        this.conversation = conversation;
    }

    public message(Integer id, String text, boolean view, Integer emiterId, Conversation conversation) {
        this.id = id;
        this.text = text;
        this.view = view;
        this.emiterId = emiterId;
        this.conversation = conversation;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isView() {
        return view;
    }

    public void setView(boolean view) {
        this.view = view;
    }

    public Integer getEmiterId() {
        return emiterId;
    }

    public void setEmiterId(Integer emiterId) {
        this.emiterId = emiterId;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
}
