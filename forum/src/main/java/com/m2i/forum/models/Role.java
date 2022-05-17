package com.m2i.forum.models;

import com.m2i.forum.enums.Roles;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Roles name;

	public Role() {}

	public Role(Roles name) {
		this.name = name;
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
	 * @return name
	 */
	public Roles getName() {
		return name;
	}

	/**
	 * @param name name à définir
	 */
	public void setName(Roles name) {
		this.name = name;
	}
}
