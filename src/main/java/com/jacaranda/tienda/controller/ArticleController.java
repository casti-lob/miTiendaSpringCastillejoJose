package com.jacaranda.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.tienda.model.Article;
import com.jacaranda.tienda.model.Category;
import com.jacaranda.tienda.service.ArticleService;
import com.jacaranda.tienda.service.CategoryService;

@Controller
public class ArticleController {
	@Autowired
	ArticleService repository;
	
	@Autowired
	CategoryService repositoryCategory;
	
	@GetMapping("articulo/list")
	public String listArticle(Model model) {
		model.addAttribute("articleList", repository.getArticles());
		return "listArticle";
	}
	
	@GetMapping("articulo/add")
	public String addArticle(Model model) {
		Article article = new Article();
		model.addAttribute("newArticle", article);
		
		//obtenemos las categorias 
		List<Category> categories = repositoryCategory.getCategories();
		model.addAttribute("categories",categories);
		return "addArticle";
	}
	
	@PostMapping("addArticle/submit")
	public String addSubmit(@ModelAttribute(name = "newArticle") Article article) {
		repository.addArticle(article);
		return "redirect:/articulo/list";
	}
	
	@GetMapping("articulo/delete")
	public String deleteArticle(Model model, @RequestParam(name = "id") Long id) {
		Article delArticle = repository.getArticle(id);
		model.addAttribute("delArticle",delArticle);
		return "deleteArticle";
	}
	
	@PostMapping("delArticle/submit")
	public String deleteSubmit(@ModelAttribute(name = "delArticle")Article delArticle) {
		repository.deleteArticle(delArticle);
		return "redirect:/articulo/list";
	}
	
	@GetMapping("articulo/update")
	public String updateArticle(Model model, @RequestParam(name = "id") Long id) {
		Article modArticle = repository.getArticle(id);
		model.addAttribute("modArticle",modArticle);
		return "updateArticle";
	}
	
	@PostMapping("updateArticle/submit")
	public String updateSubmit(@ModelAttribute(name = "modArticle")Article modArticle) {
		repository.updateArticle(modArticle);
		return "redirect:/articulo/list";
	}
}
