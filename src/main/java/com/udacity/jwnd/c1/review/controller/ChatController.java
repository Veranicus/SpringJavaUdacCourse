package com.udacity.jwnd.c1.review.controller;

import com.udacity.jwnd.c1.review.service.MessageListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private MessageListService messageListService;

    @Autowired
    public ChatController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping
    public String handleChatGetMessage(@ModelAttribute("chatForm") ChatForm chatForm, Model model) {
        model.addAttribute("chatMessages", messageListService.getChatMessages());
        return "chat";
    }

    @PostMapping
    public String handleChatPostMessage(@ModelAttribute("chatForm") ChatForm chatForm, Model model) {
        messageListService.addChatMessage(chatForm);
        chatForm.setMessageText("");
        model.addAttribute("chatMessages", messageListService.getChatMessages());
        return "chat";
    }
}
