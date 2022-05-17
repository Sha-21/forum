package com.m2i.forum.dao;

import com.m2i.forum.models.Sujet;

import java.util.Optional;

public interface SujetDao extends GenericDao<Sujet, Long> {

    public Optional<Sujet> findByTitle(String title);

    public void deleteById(Long id);
}
