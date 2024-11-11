package com.amir.notification_service.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.amir.avro.UserRegistration;

@Component
public class UserRegistrationListener {

    private static final Logger logger = LogManager.getLogger(UserRegistrationListener.class);

    @KafkaListener(topics = "user-registration", groupId = "notification-service-group", containerFactory = "kafkaListenerContainerFactory")
    public void handleUserRegistration(UserRegistration user) {
        logger.info("Received User Registration event: {}", user);
        // Simulate sending a welcome email
        sendWelcomeEmail(user);
    }

    private void sendWelcomeEmail(UserRegistration user) {
        // Here, you would integrate with an email service. We'll simulate it.
        logger.info("Sending welcome email to {}", user.getEmail());
    }
}