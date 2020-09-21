package com.ServiceOrder.ServiceOrder.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ServiceOrder.ServiceOrder.models.ServiceOrders;
import com.ServiceOrder.ServiceOrder.repository.ServiceOrdersRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")

public class ServiceOrdersResource {
	@Autowired
	ServiceOrdersRepository serviceOrdersRepository;
	
	@GetMapping("/serviceOrders")
	public List<ServiceOrders> serviceOrdersList(){
		return serviceOrdersRepository.findAll();
	}
	
	@GetMapping("/serviceOrders/{id}")
	public ServiceOrders serviceOrdersList(@PathVariable(value="id") long id){
		return serviceOrdersRepository.findById(id);
	}
	
	@PostMapping("/serviceOrders")
	public ServiceOrders serviceOrdersSave(@RequestBody ServiceOrders serviceOrders) {
		return serviceOrdersRepository.save(serviceOrders);
	}
	
	@DeleteMapping("/serviceOrders")
	public void serviceOrdersDelete(@RequestBody ServiceOrders serviceOrders) {
		serviceOrdersRepository.delete(serviceOrders);
	}
	
	@PutMapping("/serviceOrders")
	public ServiceOrders serviceOrdersUpdate(@RequestBody ServiceOrders serviceOrders) {
		return serviceOrdersRepository.save(serviceOrders);
	}
}
