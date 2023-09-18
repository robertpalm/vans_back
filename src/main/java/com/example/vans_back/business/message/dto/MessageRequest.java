package com.example.vans_back.business.message.dto;

import com.example.vans_back.domain.user.message.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Message} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest implements Serializable {
    private String messageText;
    private Integer receiverUserId;
    private Integer senderUserId;
}