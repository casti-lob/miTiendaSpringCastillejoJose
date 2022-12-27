package com.jacaranda.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.tienda.model.User;
import com.jacaranda.tienda.repository.UserRepository;
import com.jacaranda.tienda.service.UserService;

@Controller
public class UserController {
	@Autowired
		private UserService repository;
	
	
	@GetMapping("usuario/add")
	public String addUser(Model model) {
		User user = new User();
		model.addAttribute("newUser",user);
		return "addUser";
	}
	// Pendiente comprobar las 2 contrasenas
	@PostMapping("add/submit")
	public String addSubmit(@Validated @ModelAttribute("newUser") User user, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "addUser";
		}else {
			repository.addUser(user);
			return "redirect:/usuario/list";
		}
		
	}
	
	@GetMapping("usuario/list")
	public String listUser(Model model) {
		model.addAttribute("userList", repository.getUsers());
		return"listUser";
	}
	
	@GetMapping("usuario/delete")
	public String deleteUser(Model model, @RequestParam(name = "user")String user) {
		User delUser = repository.getUser(user);
		model.addAttribute("delUser",delUser);
		return "deleteUser";
	}
	
	@PostMapping("delete/submit")
	public String deleteSubmit(@ModelAttribute ("delUser")User delUser) {
		repository.deleteUser(delUser);
		return "redirect:/usuario/list";
	}
	
	@GetMapping("usuario/update")
	public String updateUser(Model model,@RequestParam(name="user")String user) {
		User updateUser = repository.getUser(user);
		model.addAttribute("updateUser",updateUser);
		return "updateUser";
	}
	
	@PostMapping("update/submit")
	public String updateSubmit(@ModelAttribute("updateUser") User updateUser) {
		repository.updateUser(updateUser);
		return"redirect:/usuario/list";
	}
	
	@GetMapping("usuario/admin")
	public String updAdmin(Model model, @RequestParam(name = "user")String user) {
		User updateAdmin =repository.getUser(user);
		model.addAttribute("updateAdmin",updateAdmin);
		return "updateAdmin";
	}
	
	@PostMapping("admin/submit")
	public String adminSubmit(@ModelAttribute("updateAdmin") User updateAdmin) {
		repository.updateUser(updateAdmin);
		return"redirect:/usuario/list";
	}
	
}
