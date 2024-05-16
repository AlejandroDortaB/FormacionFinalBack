package com.rr.conversation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rr.base.BaseController;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("conversation")
public class ConversationController extends BaseController<Conversation, ConversationService>{

    public ConversationController(ConversationService service) {
        super(service);
    }

    @PostMapping
    public ResponseEntity<Conversation> create(@RequestBody ConversationRequest entity) {
        return service.create(entity);
    }
}
