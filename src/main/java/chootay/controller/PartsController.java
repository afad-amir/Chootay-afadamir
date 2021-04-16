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

import chootay.model.SparePart;
import chootay.services.PartsService;

@RestController
public class PartsController {

	@Autowired
	private PartsService partService;
	
	@GetMapping("/parts")
	public List<SparePart> getAllUsers() {
		return partService.getAll();
	}
	@GetMapping("/parts/{id}")
	public Optional<SparePart> getUser(@PathVariable Long id) {
		return partService.get(id);
	}
	@PostMapping("/parts")
	public String addUser(@RequestBody SparePart obj) {
		 if(partService.add(obj) != null) {
			 return "success";
		 }
		 return "Invalid Request";
	}
	
	@PutMapping("/parts")
	public String updatetopic(@RequestBody SparePart obj) {
		 return partService.update(obj);
	}
	
	@DeleteMapping("/parts/{id}")
	public void deletetopic(@PathVariable Long id) {
		partService.delete(id);
	}
	
	
}
