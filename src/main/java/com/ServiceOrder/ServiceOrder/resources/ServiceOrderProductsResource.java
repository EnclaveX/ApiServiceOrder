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

import com.ServiceOrder.ServiceOrder.models.ServiceOrderProducts;
import com.ServiceOrder.ServiceOrder.repository.ServiceOrderProductsRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")

public class ServiceOrderProductsResource {
	@Autowired
	ServiceOrderProductsRepository serviceOrderProductsRepository;
	
	@GetMapping("/serviceOrderProducts")
	public List<ServiceOrderProducts> serviceOrderProductsList(){
		return serviceOrderProductsRepository.findAll();
	}
	
	@GetMapping("/serviceOrderProducts/{id}")
	public ServiceOrderProducts serviceOrderProductsList(@PathVariable(value="id") long id){
		return serviceOrderProductsRepository.findById(id);
	}
	
	@PostMapping("/serviceOrderProducts")
	public ServiceOrderProducts serviceOrderProductsSave(@RequestBody ServiceOrderProducts serviceOrderProducts) {
		return serviceOrderProductsRepository.save(serviceOrderProducts);
	}
	
	@DeleteMapping("/serviceOrderProducts")
	public void serviceOrderProductsDelete(@RequestBody ServiceOrderProducts serviceOrderProducts) {
		serviceOrderProductsRepository.delete(serviceOrderProducts);
	}
	
	@PutMapping("/serviceOrderProducts")
	public ServiceOrderProducts serviceOrderProductsUpdate(@RequestBody ServiceOrderProducts serviceOrderProducts) {
		return serviceOrderProductsRepository.save(serviceOrderProducts);
	}
}
