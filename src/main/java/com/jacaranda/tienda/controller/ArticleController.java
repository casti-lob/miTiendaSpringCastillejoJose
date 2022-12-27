package com.jacaranda.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.tienda.model.Article;
import com.jacaranda.tienda.service.ArticleService;

@Controller
public class ArticleController {
	@Autowired
	ArticleService repository;
	
	@GetMapping("articulo/list")
	public String listArticle(Model model) {
		model.addAttribute("articleList", repository.getArticles());
		return "listArticle";
	}
	
	@GetMapping("articulo/add")
	public String addArticle(Model model) {
		Article article = new Article();
		model.addAttribute("newArticle", article);
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
}
