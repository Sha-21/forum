package com.m2i.forum.services.impl;


import com.m2i.forum.dao.GenericDao;
import com.m2i.forum.dao.MessageDao;
import com.m2i.forum.dto.MessageDto;
import com.m2i.forum.models.Message;
import com.m2i.forum.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl extends GenericServiceImpl<Message, Long> implements MessageService {

    private MessageDao messageDao;

    @Autowired
    public MessageServiceImpl(@Qualifier("messageDaoImpl") GenericDao<Message, Long> genericDao, MessageDao messageDao) {
        super(genericDao);
        this.messageDao = messageDao;
    }

    @Override
    public void deleteById(Long id) {
        messageDao.deleteById(id);
    }

    public Optional<List<MessageDto>> findBySujetId(Long id) {
        return messageDao.findMessagesBySujetId(id);
    }
}
