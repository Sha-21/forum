package com.m2i.forum.services.impl;

import com.m2i.forum.dao.GenericDao;
import com.m2i.forum.dao.UserDao;
import com.m2i.forum.models.User;
import com.m2i.forum.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserService {
	
	private UserDao userDao;
	
	public UserServiceImpl() {}
	
	@Autowired
    public UserServiceImpl(
            @Qualifier("userDaoImpl") GenericDao<User, Long> genericDao) {
        super(genericDao);
        this.userDao = (UserDao) genericDao;
    }

	@Override
	public Optional<User> findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public boolean existsUsername(String username) {
		return userDao.existsUsername(username);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public boolean existsEmail(String email) {
		return userDao.existsEmail(email);
	}
	
	@Override
	public void deleteById(Long id) {
		userDao.deleteById(id);
	}
}

