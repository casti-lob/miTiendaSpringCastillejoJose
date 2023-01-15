package com.jacaranda.tienda.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

public class User implements UserDetails {
	@Id
	private String user;
	private String password;
	private String name;
	private String email;
	private boolean enabled;
	private String role;
	private String verification_code;  
	
	//Constructor completo
	public User(String user, String password, String name, String email, boolean enabled, String role,
			String verification_code) {
		super();
		this.user = user;
		this.password = password;
		this.name = name;
		this.email = email;
		this.enabled = enabled;
		this.role = role;
		this.verification_code = verification_code;
	}
	
	//Constructor sin PK
	public User(String password, String name, String email, boolean enabled, String role, String verification_code) {
		super();
		this.password = password;
		this.name = name;
		this.email = email;
		this.enabled = enabled;
		this.role = role;
		this.verification_code = verification_code;
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
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = "USER";
	}

	public String getVerification_code() {
		return verification_code;
	}

	public void setVerification_code(String verification_code) {
		this.verification_code = verification_code;
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
		return enabled;
	}
	public void setAdmin(boolean admin) {
		this.enabled = admin;
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(this.role));
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return this.password;
	}
	@Override
	public String getUsername() {
		
		return this.user;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return enabled;
	}
	
	
	
	
}
