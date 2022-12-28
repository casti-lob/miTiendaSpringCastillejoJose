package com.jacaranda.tienda.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;
	@OneToMany(mappedBy = "category")/*No lo puedo poner porque no me permite modificar las categorias cascade = CascadeType.ALL, orphanRemoval = true  */
	private List<Article> article;
	
	
	public Category(long id, String name, String description, List<Article> article) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.article = article;
	}
	
	
	public Category() {
		super();
	}


	public Category(String name, String description, List<Article> article) {
		super();
		this.name = name;
		this.description = description;
		this.article = article;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<Article> getArticle() {
		return article;
	}

	public void setArticle(List<Article> article) {
		this.article.add((Article) article);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return id == other.id;
	}
	
	
}
