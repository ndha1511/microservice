package com.microservicedemo.notification_service.controller;

import com.microservicedemo.notification_service.models.Account;
import com.microservicedemo.notification_service.models.Message;
import com.microservicedemo.notification_service.models.Statistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping("/new")
    public Account create(@RequestBody Account account) {
        Statistic statistic = new Statistic("Account " + account.getEmail() + " is created", new Date());

        // send notification
        Message message = new Message();
        message.setTo(account.getEmail());
        message.setToName(account.getName());
        message.setSubject("Kafka producer demo");
        message.setContent("Send email to account");

        kafkaTemplate.send("notification", message);
        kafkaTemplate.send("statistic", statistic);

        return account;
    }
}
