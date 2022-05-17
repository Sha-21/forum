package com.m2i.forum.services;

import com.m2i.forum.models.Message;

public interface MessageService extends GenericService<Message, Long> {

    public void deleteById(Long id);
}
