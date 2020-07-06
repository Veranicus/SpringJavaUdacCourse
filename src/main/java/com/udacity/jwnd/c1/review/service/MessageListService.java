package com.udacity.jwnd.c1.review.service;

import com.udacity.jwnd.c1.review.controller.ChatForm;
import com.udacity.jwnd.c1.review.controller.ChatMessages;
import com.udacity.jwnd.c1.review.mapper.MessagesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageListService {

    private final MessagesMapper messagesMapper;

    @Autowired
    public MessageListService(MessagesMapper messagesMapper) {
        this.messagesMapper = messagesMapper;
    }

    public void addMessage(ChatMessages message) {
        messagesMapper.insert(message);
    }

    public void addChatMessage(ChatForm chatForm) {

        String messageText = switch (chatForm.getMessageType()) {
            case "say" -> chatForm.getMessageText();
            case "shout" -> chatForm.getMessageText().toUpperCase();
            case "whisper" -> chatForm.getMessageText().toLowerCase();
            default -> null;
        };

        ChatMessages chatMessage = new ChatMessages(chatForm.getUsername(), messageText);
        messagesMapper.insert(chatMessage);
    }


    public List<ChatMessages> getMessages() {
        return messagesMapper.getAllMessages();
    }
}
