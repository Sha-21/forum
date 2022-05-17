package com.m2i.forum.dao.impl;

import com.m2i.forum.dao.RoleDao;
import com.m2i.forum.enums.Roles;
import com.m2i.forum.models.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Optional;

@Repository
public class RoleDaoImpl extends GenericDaoImpl<Role, Long> implements RoleDao {

	@Override
	public Optional<Role> findByName(Roles name) {
		Query query = entityManager.createQuery(
                "SELECT r "
                + "FROM Role r "
                + "WHERE r.name=:name")
				.setParameter("name", name);
        Role role = null;
        try {
        	role = (Role) query.getSingleResult();
        }
        catch(Exception e) {
        	logger.error("Error finding role with name: " + role);
        }
        return Optional.ofNullable(role);
	}
}
