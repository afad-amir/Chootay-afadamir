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

import chootay.model.users;
import chootay.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<users> getAllUsers() {
		return userService.getAllUsers();
	}
	@GetMapping("/users/{id}")
	public Optional<users> getUser(@PathVariable Long id) {
		return userService.getUser(id);
	}
	
	@PostMapping("/users")
	public String addUser(@RequestBody users user) {
		 if(userService.addUser(user) != null) {
			 return "success";
		 }
		 return "Invalid Request";
	}
	
	@PutMapping("/users")
	public String updatetopic(@RequestBody users user) {
		 return userService.updateUser(user);
	}
	
	@DeleteMapping("/users/{id}")
	public void deletetopic(@PathVariable Long id) {
		userService.deleteUser(id);
	}
}
