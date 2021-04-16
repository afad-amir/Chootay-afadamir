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

import chootay.model.Inventory;
import chootay.services.InventoryService;

@RestController
public class InventoryController {

	@Autowired
	private InventoryService invService;
	
	@GetMapping("/inventory")
	public List<Inventory> getAllUsers() {
		return invService.getAll();
	}
	@GetMapping("/inventory/{id}")
	public Optional<Inventory> getUser(@PathVariable Long id) {
		return invService.get(id);
	}
	@PostMapping("/inventory")
	public String addUser(@RequestBody Inventory obj) {
		 if(invService.add(obj) != null) {
			 return "success";
		 }
		 return "Invalid Request";
	}
	
	@PutMapping("/inventory")
	public String updatetopic(@RequestBody Inventory obj) {
		 return invService.update(obj);
	}
	
	@DeleteMapping("/inventory/{id}")
	public void deletetopic(@PathVariable Long id) {
		invService.delete(id);
	}
}
