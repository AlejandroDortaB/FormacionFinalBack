package com.rr.message;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rr.base.BaseController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("message")
public class MessageController extends BaseController<message, MessageService> {

    public MessageController(MessageService service) {
        super(service);
    }

    @PostMapping
    public message create(@RequestBody MessageRequest request) {
        return service.create(request);
    }

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public message chat(@DestinationVariable String roomId, MessageRequest message) {
        return service.create(message);
    }
}
