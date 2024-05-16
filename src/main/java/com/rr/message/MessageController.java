package com.rr.message;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<message> create(@RequestBody MessageRequest request) {
        return service.create(request);
    }
}
