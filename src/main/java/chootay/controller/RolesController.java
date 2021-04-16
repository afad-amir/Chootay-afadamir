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

import chootay.model.roles;
import chootay.services.RoleService;

@RestController
public class RolesController {
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/roles")
	public List<roles> getAllUsers() {
		return roleService.getAllRoles();
	}
	@GetMapping("/roles/{id}")
	public Optional<roles> getUser(@PathVariable Long id) {
		return roleService.getRole(id);
	}
	
	@PostMapping("/roles")
	public String addUser(@RequestBody roles role) {
		 if(roleService.addRole(role) != null) {
			 return "success";
		 }
		 return "Invalid Request";
	}
	
	@PutMapping("/roles")
	public String updatetopic(@RequestBody roles role) {
		 return roleService.updateRole(role);
	}
	
	@DeleteMapping("/roles/{id}")
	public void deletetopic(@PathVariable Long id) {
		roleService.deleteRole(id);
	}
}
