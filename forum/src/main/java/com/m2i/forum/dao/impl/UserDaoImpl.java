package com.m2i.forum.dao.impl;

import com.m2i.forum.dao.UserDao;
import com.m2i.forum.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Optional;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {
	
	@Override
	public Optional<User> findByUsername(String username) {
		Query query = entityManager.createQuery(
                "from User " +
                        "where username=:username");
        query.setParameter("username", username);
        User user = null;
        try {
        	user = (User) query.getSingleResult();
        }
        catch(Exception e) {
        	logger.error("Error finding user with username: " + username);
        }
        return Optional.ofNullable(user);
	}

	@Override
	public boolean existsUsername(String username) {
		Query query = entityManager.createQuery(
                "from User " +
                        "where username=:username");
        query.setParameter("username", username);
        return query.getResultList().size() > 0;
	}

	@Override
	public Optional<User> findByEmail(String email) {
		Query query = entityManager.createQuery(
                "from User " +
                        "where email=:email");
        query.setParameter("email", email);
        User user = null;
        try {
        	user = (User) query.getSingleResult();
        }
        catch(Exception e) {
        	logger.error("Error finding user with email: " + email);
        }
        return Optional.ofNullable(user);
	}

	@Override
	public boolean existsEmail(String email) {
		Query query = entityManager.createQuery(
                "from User " +
                        "where email=:email");
        query.setParameter("email", email);
        return query.getResultList().size() > 0;
	}
	
	@Override
	public void deleteById(Long id) {
		entityManager.createQuery("DELETE FROM User WHERE id=:id")
				.setParameter("id", id).executeUpdate();
	}
}
