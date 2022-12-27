package com.jacaranda.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.tienda.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
