package chootay.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chootay.model.customer;
import chootay.repos.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	public List<customer> getAll(){
		List<customer> obj =new ArrayList<>();
		customerRepo.findAll().forEach(obj::add);
		return obj;
	}
	
	public Optional<customer> get(Long id) {
		return customerRepo.findById(id);
	}

	public String add(customer obj) {
		if(customerRepo.save(obj) != null) {
			return "Data Added";
		}
		return "Invalid Request";
	}

	public String update(customer obj) {
		if(customerRepo.save(obj) != null) 
			return "Data Added";
		return "Invalid Request";
	}

	public void delete(Long id) {
		customerRepo.deleteById(id);
	}
}
