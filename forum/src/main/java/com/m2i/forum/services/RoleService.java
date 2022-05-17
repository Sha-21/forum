package com.m2i.forum.services;

import com.m2i.forum.enums.Roles;
import com.m2i.forum.models.Role;

import java.util.Optional;

public interface RoleService extends GenericService<Role, Long>{
	public Optional<Role> findByName(Roles name);
}
