package com.example.vans_back.business.message;

import com.example.vans_back.business.message.dto.MessageDto;
import com.example.vans_back.business.message.dto.MessageRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessagesController {

    @Resource
    private MessagesService messagesService;

    @GetMapping("/view")
    @Operation(summary = "Toob kõik teated andmebaasist",
            description = "tagastab info userId kaudu")
    public List<MessageDto> findMessages(@RequestParam Integer userId) {
        return messagesService.findMessages(userId);
    }

    @PostMapping
    @Operation(summary = "Saadab uue teate",
            description = "lisab ajatempli saatmise hetkel ning omistab staatuse SENT")
    public void sendMessage(@RequestBody MessageRequest messageRequest) {
        messagesService.sendMessage(messageRequest);
    }

    @PutMapping
    @Operation(summary = "Muudab teate staatuse READ-iks",
            description = "otsib messageId kaudu SENT staatusega teateid ning kirjutab staatuse üle READ-iks")
    public void setMessageRead(@RequestParam Integer messageId) {
        messagesService.setMessageRead(messageId);
    }
}
