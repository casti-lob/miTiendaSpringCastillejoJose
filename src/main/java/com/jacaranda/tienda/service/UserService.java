package com.jacaranda.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.tienda.model.User;
import com.jacaranda.tienda.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public User getUser(String user) {
		return repository.findById(user).orElse(null);
	}
	
	public List<User> getUsers(){
		return repository.findAll();
	}
	
	public User addUser(User u) {
		return repository.save(u);
	}
	
	public void deleteUser(User u) {
		repository.delete(u);
	}
	
	public User updateUser(User u) {
		if(getUser(u.getUser())!=null) {
			return repository.save(u);
		}else {
			return null;
		}
	}
}
