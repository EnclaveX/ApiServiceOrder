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

import com.ServiceOrder.ServiceOrder.models.Products;
import com.ServiceOrder.ServiceOrder.repository.ProductsRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")

public class ProductsResource {
		@Autowired
		ProductsRepository productsRepository;
		
		@GetMapping("/products")
		public List<Products> productsList(){
			return productsRepository.findAll();
		}
		
		@GetMapping("/products/{id}")
		public Products productsList(@PathVariable(value="id") long id){
			return productsRepository.findById(id);
		}
		
		@PostMapping("/products")
		public Products productsSave(@RequestBody Products products) {
			return productsRepository.save(products);
		}
		
		@DeleteMapping("/products")
		public void productsDelete(@RequestBody Products products) {
			productsRepository.delete(products);
		}
		
		@PutMapping("/products")
		public Products productsUpdate(@RequestBody Products products) {
			return productsRepository.save(products);
		}
}
