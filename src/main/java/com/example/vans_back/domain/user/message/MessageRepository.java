package com.example.vans_back.domain.user.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    @Query("select m from Message m where m.receiverUser.id = ?1 or m.senderUser.id = ?2 order by m.dateTime DESC")
    List<Message> findMessagesBy(Integer receiverId, Integer senderId);
}