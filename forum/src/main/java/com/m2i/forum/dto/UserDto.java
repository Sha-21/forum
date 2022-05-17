package com.m2i.forum.dto;

import com.m2i.forum.models.Role;

import java.util.HashSet;
import java.util.Set;

public class UserDto {
	public Long id;
	public String username;
	public String email;
	public Set<Role> roles = new HashSet<>();

	public UserDto() {}

	/**
	 * @param username
	 * @param email
	 * @param roles
	 */
	public UserDto(Long id, String username, String email, Set<Role> roles) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}

	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id id à définir
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username username à définir
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email email à définir
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles roles à définir
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserDto [username=" + username + ", email=" + email + ", roles=" + roles + "]";
	}
}
