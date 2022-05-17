package com.m2i.forum.services.impl;

import com.m2i.forum.dao.GenericDao;
import com.m2i.forum.dao.MessageDao;
import com.m2i.forum.dao.SujetDao;
import com.m2i.forum.models.Sujet;
import com.m2i.forum.services.SujetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SujetServiceImpl extends GenericServiceImpl<Sujet, Long> implements SujetService {

    private SujetDao sujetDao;
    private MessageDao messageDao;

    @Autowired
    public SujetServiceImpl(@Qualifier("sujetDaoImpl") GenericDao<Sujet, Long> genericDao, SujetDao sujetDao, MessageDao messageDao) {
        super(genericDao);
        this.sujetDao = sujetDao;
        this.messageDao = messageDao;
    }

    @Override
    public Optional<Sujet> findByTitle(String title) {
        return sujetDao.findByTitle(title);
    }

    @Override
    public void deleteById(Long id) {
        messageDao.deleteBySujetId(id);
        sujetDao.deleteById(id);
    }
}
