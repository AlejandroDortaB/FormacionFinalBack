package com.rr.conversation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rr.base.BaseService;
import com.rr.user.User;
import com.rr.user.UserRepository;

@Service
public class ConversationService extends BaseService<Conversation, ConversationRepository>{

    UserRepository userRepository;
    public ConversationService(ConversationRepository repository,UserRepository userRepository) {
        super(repository);  
        this.userRepository=userRepository;
    }

    public ResponseEntity<Conversation> create(ConversationRequest request) {
        List<User> userFounds = new ArrayList<>();
        for (Integer userId : request.getUsersId()) {
            Optional<User> userOpt = this.userRepository.findById(userId);
            userOpt.ifPresent(userFounds::add);
        }
    
        if (userFounds.size() >= 2) {
            Conversation conversation = new Conversation(userFounds);
            for (User user : userFounds) {
                user.getConversations().add(conversation);
            }
    
            Conversation savedConversation = repository.save(conversation);
            userRepository.saveAll(userFounds);
    
            return ResponseEntity.status(HttpStatus.CREATED).body(savedConversation);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

}
