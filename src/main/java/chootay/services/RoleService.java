package chootay.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chootay.model.roles;
import chootay.repos.RolesRepo;

@Service
public class RoleService {

	@Autowired
	private RolesRepo rolesRepo;
	
	public List<roles> getAllRoles(){
		List<roles> role =new ArrayList<>();
		rolesRepo.findAll().forEach(role::add);
		return role;
	}
	
	public Optional<roles> getRole(Long id) {
		return rolesRepo.findById(id);
	}

	public String addRole(roles role) {
		if(rolesRepo.save(role) != null) {
			return "Data Added";
		}
		return "Invalid Request";
	}

	public String updateRole(roles role) {
		if(rolesRepo.save(role) != null) 
			return "Data Added";
		return "Invalid Request";
	}

	public void deleteRole(Long id) {
		rolesRepo.deleteById(id);
	}
}
