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

import chootay.model.BikeRecord;
import chootay.services.BikeService;

@RestController
public class BikeController {

	@Autowired
	private BikeService bikeService;
	
	@GetMapping("/bike")
	public List<BikeRecord> getAllUsers() {
		return bikeService.getAll();
	}
	@GetMapping("/bike/{id}")
	public Optional<BikeRecord> getUser(@PathVariable Long id) {
		return bikeService.get(id);
	}
	@PostMapping("/bike")
	public String addUser(@RequestBody BikeRecord obj) {
		 if(bikeService.add(obj) != null) {
			 return "success";
		 }
		 return "Invalid Request";
	}
	
	@PutMapping("/bike")
	public String updatetopic(@RequestBody BikeRecord obj) {
		 return bikeService.update(obj);
	}
	
	@DeleteMapping("/bike/{id}")
	public void deletetopic(@PathVariable Long id) {
		bikeService.delete(id);
	}
}
