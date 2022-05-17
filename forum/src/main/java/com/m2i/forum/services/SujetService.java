package com.m2i.forum.services;

import com.m2i.forum.models.Sujet;

import java.util.Optional;

public interface SujetService extends GenericService<Sujet, Long> {

    public Optional<Sujet> findByTitle(String title);

    public void deleteById(Long id);
}
