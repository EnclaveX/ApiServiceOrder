package com.ServiceOrder.ServiceOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ServiceOrder.ServiceOrder.models.ServiceOrderProducts;

public interface ServiceOrderProductsRepository extends JpaRepository<ServiceOrderProducts, Long>{
	ServiceOrderProducts findById(long id);
	
	ServiceOrderProducts findByServiceOrder(long serviceOrderId);
}