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

import chootay.model.Sales;
import chootay.services.SalesSerive;

@RestController
public class SalesController {

	@Autowired
	private SalesSerive saleService;
	
	
	@GetMapping("/sales")
	public List<Sales> getAllUsers() {
		return saleService.getAll();
	}
	@GetMapping("/sales/{id}")
	public Optional<Sales> getUser(@PathVariable Long id) {
		return saleService.get(id);
	}
	@PostMapping("/sales")
	public String addUser(@RequestBody Sales obj) {
		 if(saleService.add(obj) != null) {
			 return "success";
		 }
		 return "Invalid Request";
	}
	
	@PutMapping("/sales")
	public String updatetopic(@RequestBody Sales obj) {
		 return saleService.update(obj);
	}
	
	@DeleteMapping("/sales/{id}")
	public void deletetopic(@PathVariable Long id) {
		saleService.delete(id);
	}
	
}
