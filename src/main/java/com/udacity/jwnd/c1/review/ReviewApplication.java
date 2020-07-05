package com.udacity.jwnd.c1.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
//@Configuration
// Those two annotations are already in SpringBootApplication annotation.
//Configuration enables to configure spring application context
//@EnableAutoConfiguration
//EnableAuoConfiguration tries to automatically find the best bean for as dependency of another bean
public class ReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReviewApplication.class, args);
    }

    @Bean
	@Primary
    public String basicMessage() {
        System.out.println("inside basicMessage");
        return "Hello";
    }
    @Bean
    public String uppercaseMessage(MessageService messageService) {
        System.out.println("Inside uppercaseMessage bean");
        return messageService.toUppercase();
    }
    @Bean
    public String lowercaseMessage(MessageService messageService) {
        System.out.println("Inside lowercaseMessage bean");
        return messageService.toLowerCase();
    }
    @Bean
    public String compoundMessage(String bassicMessage) {
        System.out.println("inside compound message " + basicMessage());
        return bassicMessage + " , Spring!";
    }

    @Bean
//	Spring cant determine which bean to use both string parameters containing message
    public int characterCount(String message) {
		System.out.println("Message length is: " + message.length());
        return message.length();
    }


}
