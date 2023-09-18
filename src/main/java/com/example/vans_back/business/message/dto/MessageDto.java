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
public class MessageDto implements Serializable {
    private Integer messageId;
    private String messageText;
    private String receiverUsername;
    private String senderUsername;
    private String messageDateTime;
    private String messageStatus;
}