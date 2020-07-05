package com.udacity.jwnd.c1.review.service;

import com.udacity.jwnd.c1.review.controller.ChatForm;
import com.udacity.jwnd.c1.review.controller.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageListService {

    private List<String> messages;
    private List<ChatMessage> chatMessages;

    @PostConstruct
    public void postConstruct() {
        this.messages = new ArrayList<>();
        this.chatMessages = new ArrayList<>();
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public void addChatMessage(ChatForm chatForm) {
        if (chatForm.getMessageType().equalsIgnoreCase("shout")) {
            chatMessages.add(new ChatMessage(chatForm.getMessageText().toUpperCase(), chatForm.getUsername().toUpperCase()));
        } else {
            chatMessages.add(new ChatMessage(chatForm.getMessageText(), chatForm.getUsername()));
        }
    }

    public void setChatMessages(List<ChatMessage> chatMessages) {
        this.chatMessages = chatMessages;
    }

    public List<String> getMessages() {
        return new ArrayList<>(this.messages);
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }
}
