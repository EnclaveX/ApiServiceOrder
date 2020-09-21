package com.ServiceOrder.ServiceOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ServiceOrder.ServiceOrder.models.Users;

public interface UsersRepository extends JpaRepository<Users, String>{
	Users findById(long id);
	
	Users findByEmail(String email);
}