package com.jacaranda.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.tienda.model.Article;
import com.jacaranda.tienda.repository.ArticleRepository;

@Service
public class ArticleService {
	@Autowired
	ArticleRepository repository;
	
	public Article getArticle(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Article> getArticles(){
		return repository.findAll();
	}
	
	public Article addArticle(Article a) {
		return repository.save(a);
	}
	
	public void deleteArticle(Article a) {
		repository.delete(a);
	}
	
	public Article updateArticle(Article a) {
		if(getArticle(a.getId())!=null) {
			return repository.save(a);
		}else {
			return null;
		}
	}
}
