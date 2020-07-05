package com.udacity.jwnd.c1.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MessageService {

    private String message;

    @Autowired
    public MessageService(String message) {
        this.message = message;
    }

    public String toUppercase() {
        System.out.println("Message service upperCase");
        return message.toUpperCase();
    }

    public String toLowerCase() {
        System.out.println("Message service lowerCase");
        return message.toLowerCase();
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService bean");
    }

}
