package com.m2i.forum.dao;

import com.m2i.forum.models.Section;

import java.util.Optional;

public interface SectionDao extends GenericDao<Section, Long> {

    public Optional<Section> findByTitle(String title);

    public void deleteById(Long id);
}
