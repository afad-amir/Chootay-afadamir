package chootay.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chootay.model.Inventory;
import chootay.repos.InventoryRepo;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepo invRepo;
	
	public List<Inventory> getAll(){
		List<Inventory> obj =new ArrayList<>();
		invRepo.findAll().forEach(obj::add);
		return obj;
	}
	
	public Optional<Inventory> get(Long id) {
		return invRepo.findById(id);
	}

	public String add(Inventory obj) {
		if(invRepo.save(obj) != null) {
			return "Data Added";
		}
		return "Invalid Request";
	}

	public String update(Inventory obj) {
		if(invRepo.save(obj) != null) 
			return "Data Added";
		return "Invalid Request";
	}

	public void delete(Long id) {
		invRepo.deleteById(id);
	}
	
}
