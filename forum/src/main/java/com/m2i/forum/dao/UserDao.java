package com.m2i.forum.dao;

import com.m2i.forum.models.User;

import java.util.Optional;

public interface UserDao extends GenericDao<User, Long> {
	public Optional<User> findByUsername(String username);
	public boolean existsUsername(String username);
	public Optional<User> findByEmail(String email);
	public boolean existsEmail(String email);
	public void deleteById(Long id);
}
