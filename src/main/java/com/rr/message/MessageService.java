package com.rr.message;


import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rr.base.BaseService;
import com.rr.conversation.Conversation;
import com.rr.conversation.ConversationRepository;


@Service
public class MessageService extends BaseService<message, MessageRepository>{
    ConversationRepository conversationRepository;

    public MessageService(MessageRepository repository,ConversationRepository conversationRepository) {
        super(repository);
        this.conversationRepository=conversationRepository;
    }

     public message create(MessageRequest request) {
        Optional<Conversation> conversationOpt=  this.conversationRepository.findById(request.getCoversationId());
       if(conversationOpt.isPresent()){
        Conversation conversation = conversationOpt.get();
        message message = new message(request.getText(),request.isView(),request.getEmiterId(),conversation);
        repository.save(message);
        return message;
       }
        return null;
    }
}
