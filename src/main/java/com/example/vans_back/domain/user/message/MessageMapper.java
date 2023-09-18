package com.example.vans_back.domain.user.message;

import com.example.vans_back.business.Status;
import com.example.vans_back.business.message.dto.MessageDto;
import com.example.vans_back.business.message.dto.MessageRequest;
import com.example.vans_back.util.TimeUtil;
import org.mapstruct.*;

import java.time.Instant;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Instant.class, Status.class})
public interface MessageMapper {


    @Mapping(source = "id", target = "messageId")
    @Mapping(source = "dateTime", target = "messageDateTime", qualifiedByName = "instantToString")
    @Mapping(source = "status", target = "messageStatus")
    @Mapping(source = "text", target = "messageText")
    @Mapping(source = "receiverUser.username", target = "receiverUsername")
    @Mapping(source = "senderUser.username", target = "senderUsername")
    MessageDto toMessageDto(Message message);

    List<MessageDto> toMessageDtos(List<Message> messages);

    @Mapping(source = "messageText", target = "text")
    @Mapping(expression = "java(Status.SENT.getLetter())", target = "status")
    @Mapping(expression = "java(Instant.now())", target = "dateTime")
    Message toMessage(MessageRequest messageRequest);

    @Named("instantToString")
    static String instantToString(Instant instant) {
        return TimeUtil.instantToString(instant);
    }
}