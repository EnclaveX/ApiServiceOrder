package com.ServiceOrder.ServiceOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ServiceOrder.ServiceOrder.models.ServiceOrders;

public interface ServiceOrdersRepository extends JpaRepository<ServiceOrders, Long>{
	ServiceOrders findById(long id);
}