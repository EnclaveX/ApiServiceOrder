package com.ServiceOrder.ServiceOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ServiceOrder.ServiceOrder.models.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Long>{
	Customers findById(long id);
}