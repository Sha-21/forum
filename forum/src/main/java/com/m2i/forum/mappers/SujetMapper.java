package com.m2i.forum.mappers;

import com.m2i.forum.dto.SujetDto;
import com.m2i.forum.dto.UserDto;
import com.m2i.forum.models.Message;
import com.m2i.forum.models.Section;
import com.m2i.forum.models.Sujet;
import com.m2i.forum.models.User;
import com.m2i.forum.services.impl.SujetServiceImpl;
import com.m2i.forum.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SujetMapper {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    SujetServiceImpl sujetService;

    public SujetDto toDto(Sujet sujet) {
        Long id = sujet.getId();
        String title = sujet.getTitle();
        Section section = sujet.getSection();
        UserDto author = userMapper.toDto(sujet.getAuthor());
        List<Message> messages = sujet.getMessages();
        String firstMessage = sujet.getFirstMessage();

        return new SujetDto(id, title, section, author, messages, firstMessage, sujet.getLikes());
    }

    public Sujet toEntity(SujetDto sujetDto) {
        User user = userService.findById(sujetDto.getAuthor().getId());
        return new Sujet(sujetDto.getTitle(), sujetDto.getSection(), user, sujetDto.getFirstMessage());
    }
}
