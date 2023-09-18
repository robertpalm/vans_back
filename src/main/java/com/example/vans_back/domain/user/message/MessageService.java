package com.example.vans_back.domain.user.message;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Resource
    private MessageRepository messageRepository;

    public List<Message> findAllMessagesBy(Integer userId) {
        return messageRepository.findMessagesBy(userId, userId);
    }

    public void addMessage(Message message) {
        messageRepository.save(message);
    }

    public Message findMessageBy(Integer messageId) {
        return messageRepository.findById(messageId).get();
    }
}
