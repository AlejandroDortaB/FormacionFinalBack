package com.rr.conversation;

import java.util.List;

public class ConversationRequest {
    List<Integer> usersId;


    
    public ConversationRequest() {
    }

    public ConversationRequest(List<Integer> usersId) {
        this.usersId = usersId;
    } 

    public List<Integer> getUsersId() {
        return usersId;
    }

    public void setUsersId(List<Integer> usersId) {
        this.usersId = usersId;
    }

   



    
}
