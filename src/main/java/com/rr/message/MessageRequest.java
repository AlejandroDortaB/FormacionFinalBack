package com.rr.message;

public class MessageRequest {
    String text;
    boolean view;
    Integer emiterId;
    Integer coversationId;
    public MessageRequest() {
    }
    public MessageRequest(String text, boolean view, Integer emiterId, Integer coversationId) {
        this.text = text;
        this.view = view;
        this.emiterId = emiterId;
        this.coversationId = coversationId;
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
    public Integer getCoversationId() {
        return coversationId;
    }
    public void setCoversationId(Integer coversationId) {
        this.coversationId = coversationId;
    }
    
    
    
    
}
