package chootay.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import chootay.model.customer;
import chootay.services.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService custService;
	
	@GetMapping("/customer")
	public List<customer> getAllUsers() {
		return custService.getAll();
	}
	@GetMapping("/customer/{id}")
	public Optional<customer> getUser(@PathVariable Long id) {
		return custService.get(id);
	}
	@PostMapping("/customer")
	public String addUser(@RequestBody customer obj) {
		 if(custService.add(obj) != null) {
			 return "success";
		 }
		 return "Invalid Request";
	}
	
	@PutMapping("/customer")
	public String updatetopic(@RequestBody customer obj) {
		 return custService.update(obj);
	}
	
	@DeleteMapping("/customer/{id}")
	public void deletetopic(@PathVariable Long id) {
		custService.delete(id);
	}
}
