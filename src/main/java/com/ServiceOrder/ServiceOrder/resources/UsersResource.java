package com.ServiceOrder.ServiceOrder.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ServiceOrder.ServiceOrder.models.Users;
import com.ServiceOrder.ServiceOrder.repository.UsersRepository;
import com.ServiceOrder.util.AES;

@RestController
@RequestMapping(value="/api")

public class UsersResource {
	@Autowired
	UsersRepository usersRepository;
	
	
	@GetMapping("/users")
	public List<Users> usersList(){
		return usersRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Users usersList(@PathVariable(value="id") long id){
		return usersRepository.findById(id);
	}
	
	@PostMapping("/users")
	public Users usersSave(@RequestBody Users users) {
		final String secretKey = "AGAHERESDQWDWS";
	     
		users.setPassword(AES.encrypt(users.getPassword(), secretKey));
	    
		return usersRepository.save(users);
	}
	
	@PostMapping("/signin")
	public Users signIn(@RequestBody Users usersParam) {
		Users user = usersRepository.findByEmail(usersParam.getEmail());
		
		final String secretKey = "AGAHERESDQWDWS";
	     
		final String passwordParam = AES.encrypt(usersParam.getPassword(), secretKey);
		
		if (user.getPassword().equals(passwordParam)) {
			return user;	
		} else {		
			final Users nullUser = new Users();
			
			return nullUser;
		}
	}
	
	@DeleteMapping("/users")
	public void usersDelete(@RequestBody Users users) {
		usersRepository.delete(users);
	}
	
	@PutMapping("/users")
	public Users usersUpdate(@RequestBody Users users) {
		return usersRepository.save(users);
	}
}

