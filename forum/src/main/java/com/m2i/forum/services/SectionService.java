package com.m2i.forum.services;

import com.m2i.forum.models.Section;

import java.util.Optional;

public interface SectionService extends GenericService<Section, Long> {

    public Optional<Section> findByTitle(String title);

    public void deleteById(Long id);
}
