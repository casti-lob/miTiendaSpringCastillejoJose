package com.jacaranda.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.tienda.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
