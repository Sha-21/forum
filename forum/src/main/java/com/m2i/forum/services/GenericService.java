package com.m2i.forum.services;

import java.util.List;

public interface GenericService<E, K> {
	public void add(E entity);
    public void save(E entity);
    public E update(E entity);
    public void delete(E entity);
    public E findById(K key);
    public List<E> findAll();
}

