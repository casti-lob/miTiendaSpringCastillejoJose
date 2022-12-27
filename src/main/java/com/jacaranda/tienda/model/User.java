package com.jacaranda.tienda.model;

import java.util.Objects;

import org.apache.commons.codec.digest.DigestUtils;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

public class User {
	@Id
	private String user;
	private String password;
	private String name;
	private String email;
	private boolean admin;
	
	//Constructor completo
	public User(String user, String password, String name, String email, boolean admin) throws UserException {
		super();
		this.setUser(user);
		this.setPassword(password);
		this.setName(name);
		this.setEmail(email);
		this.admin = false;
	}
	//Constructor sin PK
	public User(String password, String name, String email, boolean admin) throws UserException {
		super();
		this.setPassword(password);
		this.setName(name);
		this.setEmail(email);
		this.admin = false;
	}
	
	//Constructor vacio
	public User() {
		super();
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) throws UserException {
		if(user==null||user.isEmpty()) {
			throw new UserException("El campo nick es obligatorio");
		}else {
			this.user = user;
		}
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) throws UserException {
		if(password==null||password.isEmpty()) {
			throw new UserException("El campo password es obligatorio");
		}else {
			String encript = DigestUtils.md5Hex(password);
			this.password = encript;
		}
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) throws UserException {
		if(name==null||name.isEmpty()) {
			throw new UserException("El campo name es obligatorio");
		}else {
			this.name = name;
		}
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) throws UserException {
		if(email==null||email.isEmpty()) {
			throw new UserException("El campo email es obligatorio");
		}else {
			this.email = email;
		}
		
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(user, other.user);
	}
	
	
	
	
}
