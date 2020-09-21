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

import com.ServiceOrder.ServiceOrder.models.Customers;
import com.ServiceOrder.ServiceOrder.repository.CustomersRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")

public class CustomersResource {
	@Autowired
	CustomersRepository customersRepository;
	
	@GetMapping("/customers")
	public List<Customers> customersList(){
		return customersRepository.findAll();
	}
	
	@GetMapping("/customers/{id}")
	public Customers customersList(@PathVariable(value="id") long id){
		return customersRepository.findById(id);
	}
	
	@PostMapping("/customers")
	public Customers customersSave(@RequestBody Customers customers) {
		return customersRepository.save(customers);
	}
	
	@DeleteMapping("/customers")
	public void customersDelete(@RequestBody Customers customers) {
		customersRepository.delete(customers);
	}
	
	@PutMapping("/customers")
	public Customers customersUpdate(@RequestBody Customers customers) {
		return customersRepository.save(customers);
	}
}
