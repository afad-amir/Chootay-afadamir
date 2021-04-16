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

import chootay.model.UserRole;
import chootay.services.UserRoleService;

@RestController
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;
	
	
	
	@GetMapping("/userrole")
	public List<UserRole> getAllUsers() {
		return userRoleService.getAllRoles();
	}
	@GetMapping("/userrole/{id}")
	public Optional<UserRole> getUser(@PathVariable Long id) {
		return userRoleService.getRole(id);
	}
	
	@PostMapping("/userrole")
	public String addUser(@RequestBody UserRole role) {
		 if(userRoleService.addRole(role) != null) {
			 return "success";
		 }
		 return "Invalid Request";
	}
	
	@PutMapping("/userrole")
	public String updatetopic(@RequestBody UserRole role) {
		 return userRoleService.updateRole(role);
	}
	
	@DeleteMapping("/userrole/{id}")
	public void deletetopic(@PathVariable Long id) {
		userRoleService.deleteRole(id);
	}
}
