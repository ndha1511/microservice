package com.microservicedemo.notification.services;

import com.microservicedemo.notification.models.Message;
import jakarta.mail.MessagingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



@Service
public class MessageService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmailService emailService;

    @KafkaListener(id = "notificationGroup", topics = "notification")
    public void listen(Message message) {
        logger.info("Received: ", message.getTo());
        try {
            emailService.sendEmail(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
