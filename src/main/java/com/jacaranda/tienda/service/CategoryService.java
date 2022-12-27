package com.jacaranda.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.tienda.model.Category;
import com.jacaranda.tienda.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository repository;
	
	public Category getCategory(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Category> getCategories(){
		return repository.findAll();
	}
	
	public Category addCategory(Category c) {
		return repository.save(c);
	}
	
	public void deleteCategory(Category c) {
		repository.delete(c);
	}
	
	public Category updateUser(Category c) {
		if(getCategory(c.getId())!=null) {
			return repository.save(c);
		}else {
			return null;
		}
	}
}
