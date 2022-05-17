package com.m2i.forum.services.impl;

import com.m2i.forum.dao.GenericDao;
import com.m2i.forum.dao.SectionDao;
import com.m2i.forum.models.Section;
import com.m2i.forum.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SectionServiceImpl extends GenericServiceImpl<Section, Long> implements SectionService {

    private SectionDao sectionDao;

    @Autowired
    public SectionServiceImpl(@Qualifier("sectionDaoImpl") GenericDao<Section, Long> genericDao, SectionDao sectionDao) {
        super(genericDao);
        this.sectionDao = sectionDao;
    }

    @Override
    public Optional<Section> findByTitle(String title) {
        return sectionDao.findByTitle(title);
    }

    @Override
    public void deleteById(Long id) {
        sectionDao.deleteById(id);
    }
}
