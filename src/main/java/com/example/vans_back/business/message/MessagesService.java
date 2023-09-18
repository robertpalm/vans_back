package com.example.vans_back.business.message;

import com.example.vans_back.business.Status;
import com.example.vans_back.business.message.dto.MessageDto;
import com.example.vans_back.business.message.dto.MessageRequest;
import com.example.vans_back.domain.user.User;
import com.example.vans_back.domain.user.UserService;
import com.example.vans_back.domain.user.message.Message;
import com.example.vans_back.domain.user.message.MessageMapper;
import com.example.vans_back.domain.user.message.MessageService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesService {

    @Resource
    private MessageService messageService;

    @Resource
    private MessageMapper messageMapper;

    @Resource
    private UserService userService;

    public List<MessageDto> findMessages(Integer userId) {
        List<Message> messages = messageService.findAllMessagesBy(userId);
        return messageMapper.toMessageDtos(messages);
    }

    public void sendMessage(MessageRequest messageRequest) {
        Message message = messageMapper.toMessage(messageRequest);
        User sender = userService.getUserBy(messageRequest.getSenderUserId());
        message.setSenderUser(sender);
        User receiver = userService.getUserBy(messageRequest.getReceiverUserId());
        message.setReceiverUser(receiver);
        messageService.addMessage(message);
    }

    public void setMessageRead(Integer messageId) {
        Message message = messageService.findMessageBy(messageId);
        message.setStatus(Status.READ.getLetter());
        messageService.addMessage(message);
    }
}
