package chootay.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chootay.model.UserRole;
import chootay.repos.UserRoleRepo;

@Service
public class UserRoleService {
	@Autowired
	private UserRoleRepo userRoleRepo;
	
	public List<UserRole> getAllRoles(){
		List<UserRole> role =new ArrayList<>();
		userRoleRepo.findAll().forEach(role::add);
		return role;
	}
	
	public Optional<UserRole> getRole(Long id) {
		return userRoleRepo.findById(id);
	}

	public String addRole(UserRole role) {
		if(userRoleRepo.save(role) != null) {
			return "Data Added";
		}
		return "Invalid Request";
	}

	public String updateRole(UserRole role) {
		if(userRoleRepo.save(role) != null) 
			return "Data Added";
		return "Invalid Request";
	}

	public void deleteRole(Long id) {
		userRoleRepo.deleteById(id);
	}
}
