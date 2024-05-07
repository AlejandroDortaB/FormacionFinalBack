package com.rr.plates;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rr.base.BaseController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("foodPlates")
public class FoodPlatesController extends BaseController<FoodPlates, FoodPlatesServices>{

    public FoodPlatesController(FoodPlatesServices service) {
        super(service);
    }

    @PostMapping
    public ResponseEntity<FoodPlates> create(@RequestBody FoodPlatesRequest entity) {
        return service.create(entity);
    }

}
