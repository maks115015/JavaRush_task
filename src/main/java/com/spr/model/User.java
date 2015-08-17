package com.spr.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private Integer age;

	@Column(name = "isAdmin")
	private byte isAdmin;

	@Column(name = "createdDate")
	private Timestamp date;

	public Timestamp getDate() {

		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public byte getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(byte isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
