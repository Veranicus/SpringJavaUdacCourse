package com.udacity.jwnd.c1.review.controller;

import com.udacity.jwnd.c1.review.model.MessageForm;
import com.udacity.jwnd.c1.review.service.MessageListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Instant;

@Controller
public class HomeController {

    private MessageListService messageListService;

    @Autowired
    public HomeController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping("/home")
    public String getHomePage(@ModelAttribute("newMessage") MessageForm newMessage, Model model) {
        model.addAttribute("welcomeMessage", Instant.now().toString());
        model.addAttribute("greetings", messageListService.getMessages());
        return "home";
    }

    @PostMapping("/home")
    public String addMessage(@ModelAttribute("newMessage") MessageForm newMessage, Model model) {
        messageListService.addMessage(new ChatMessages(newMessage.getText(), "null"));
        model.addAttribute("greetings", messageListService.getMessages());
        newMessage.setText("");
        return "home";
    }
}
