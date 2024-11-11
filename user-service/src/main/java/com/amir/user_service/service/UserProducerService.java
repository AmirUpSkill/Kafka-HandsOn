package com.amir.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.amir.avro.UserRegistration;

@Service 
public class UserProducerService {

    private static final String TOPIC ="user-registration";
    @Autowired
    private KafkaTemplate<String , UserRegistration> kafkaTemplate;

    public void sendUserRegistration(UserRegistration user){
        kafkaTemplate.send(TOPIC, user.getId().toString(), user);
    }
    
}
