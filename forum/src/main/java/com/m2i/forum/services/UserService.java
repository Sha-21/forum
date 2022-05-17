package com.m2i.forum.services;

import com.m2i.forum.models.User;

import java.util.Optional;

public interface UserService extends GenericService<User, Long>{
	public Optional<User> findByUsername(String username);
	public boolean existsUsername(String username);
	public Optional<User> findByEmail(String email);
	public boolean existsEmail(String email);
	public void deleteById(Long id);
}

