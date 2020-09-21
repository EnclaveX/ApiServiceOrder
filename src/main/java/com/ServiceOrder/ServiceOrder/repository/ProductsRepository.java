package com.ServiceOrder.ServiceOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ServiceOrder.ServiceOrder.models.Products;

public interface ProductsRepository extends JpaRepository<Products, Long>{
	Products findById(long id);
}