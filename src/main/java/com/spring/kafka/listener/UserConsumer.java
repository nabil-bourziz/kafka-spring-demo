package com.spring.kafka.listener;

import com.spring.kafka.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserConsumer {

    @KafkaListener(topics = "user", groupId = "G1", containerFactory = "userKafkaListenerContainerFactory")
    public void consume(User user) {
        System.out.println(user.toString());
    }

}
