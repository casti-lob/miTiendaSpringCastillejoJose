package com.jacaranda.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.tienda.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}
