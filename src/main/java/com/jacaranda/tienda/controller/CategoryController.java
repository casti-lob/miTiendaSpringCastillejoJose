package com.jacaranda.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.tienda.model.Category;
import com.jacaranda.tienda.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	CategoryService repository;
	
	@GetMapping("categoria/list")
	public String listCategory(Model model) {
		model.addAttribute("categoryList", repository.getCategories());
		return "listCategory";
	}
	
	@GetMapping("categoria/add")
	public String addCategory(Model model) {
		Category category = new Category();
		model.addAttribute("newCategory", category);
		return "addCategory";
	}
	
	@PostMapping("addCategory/submit")
	public String addSubmit(@ModelAttribute(name = "newCategory") Category category) {
		repository.addCategory(category);
		return "redirect:/categoria/list";
	}
	
	@GetMapping("categoria/delete")
	public String deleteCategory(Model model, @RequestParam(name = "id")Long id) {
		Category delCategory = repository.getCategory(id);
		model.addAttribute("delCategory",delCategory);
		return "deleteCategory";
	}
	
	@PostMapping("deleteCategory/submit")
	public String deleteSubmit(@ModelAttribute ("delCategory")Category delCategory) {
		repository.deleteCategory(delCategory);
		return "redirect:/categoria/list";
	}
	
	@GetMapping("categoria/update")
	public String updateCategory(Model model,@RequestParam(name="id")Long id) {
		Category updateCategory = repository.getCategory(id);
		model.addAttribute("updateCategory",updateCategory);
		return "updateCategory";
	}
	
	@PostMapping("updateCategory/submit")
	public String updateSubmit(@ModelAttribute("updateCategory") Category updateCategory) {
		repository.updateCategory(updateCategory);
		return"redirect:/categoria/list";
	}
}
