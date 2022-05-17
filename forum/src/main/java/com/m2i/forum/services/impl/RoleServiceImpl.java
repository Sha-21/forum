package com.m2i.forum.services.impl;

import com.m2i.forum.dao.GenericDao;
import com.m2i.forum.dao.RoleDao;
import com.m2i.forum.enums.Roles;
import com.m2i.forum.models.Role;
import com.m2i.forum.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, Long> implements RoleService {

	private RoleDao roleDao;
	
	public RoleServiceImpl() {}
	
	@Autowired
	public RoleServiceImpl(
			@Qualifier("roleDaoImpl") GenericDao<Role, Long> genericDao) {
		super(genericDao);
		this.roleDao = (RoleDao) genericDao;
	}
	
	@Override
	public Optional<Role> findByName(Roles name) {
		return roleDao.findByName(name);
	}

}
