package com.m2i.forum.dao;

import com.m2i.forum.enums.Roles;
import com.m2i.forum.models.Role;

import java.util.Optional;

public interface RoleDao extends GenericDao<Role, Long>{
	public Optional<Role> findByName(Roles name);
}
