package com.m2i.forum.mappers;

import com.m2i.forum.dto.MessageDto;
import com.m2i.forum.dto.UserDto;
import com.m2i.forum.models.Message;
import com.m2i.forum.models.Sujet;
import com.m2i.forum.models.User;
import com.m2i.forum.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MessageMapper {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserServiceImpl userService;

    public MessageDto toDto(Message message) {
        Long id = message.getId();
        String content = message.getContent();
        UserDto author = userMapper.toDto(message.getAuthor());
        Sujet sujet = message.getSujet();
        LocalDateTime createdAt = message.getCreatedAt();
        LocalDateTime updatedAt = message.getUpdatedAt();

        return new MessageDto(id, content, author, sujet, createdAt, updatedAt, message.getLikes());
    }

    public Message toEntity(MessageDto messageDto) {
        User user = userService.findById(messageDto.getAuthor().getId());
        return new Message(user, messageDto.getContent(), messageDto.getSujet());
    }
}
