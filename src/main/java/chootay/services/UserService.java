package chootay.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import chootay.model.users;
import chootay.repos.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<users> getAllUsers(){
		List<users> user =new ArrayList<>();
		userrepo.findAll().forEach(user::add);
		return user;
	}
	
	public Optional<users> getUser(Long id) {
		return userrepo.findById(id);
	}

	public String addUser(users user) {
		
		users us=new users();
		us.setFirstname(user.getFirstname());
		us.setEmail(user.getFirstname());
		us.setPassword(passwordEncoder.encode(user.getPassword()));
		us.setLastname(user.getLastname());
		us.setUserid(user.getUserid());
		if(userrepo.save(us) != null) {
			return "Data Added";
		}
		return "Invalid Request";
	}

	public String updateUser(users user) {
		if(userrepo.save(user) != null) 
			return "Data Added";
		return "Invalid Request";
	}

	public void deleteUser(Long id) {
		userrepo.deleteById(id);
	}
}
