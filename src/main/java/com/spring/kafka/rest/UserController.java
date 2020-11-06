package com.spring.kafka.rest;

import com.spring.kafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private KafkaTemplate<String, User> userKafkaProducer;

    @GetMapping("/{name}/{address}/{age}")
    public String publishUser(@PathVariable String name, @PathVariable String address, @PathVariable int age) {
        userKafkaProducer.send("user", new User(name, address, age));
        return "Published successfully";
    }
}
