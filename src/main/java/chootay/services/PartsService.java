package chootay.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chootay.model.SparePart;
import chootay.repos.PartsRepo;

@Service
public class PartsService {

	@Autowired
	private PartsRepo pastRepo;
	
	public List<SparePart> getAll(){
		List<SparePart> obj =new ArrayList<>();
		pastRepo.findAll().forEach(obj::add);
		return obj;
	}
	
	public Optional<SparePart> get(Long id) {
		return pastRepo.findById(id);
	}

	public String add(SparePart obj) {
		if(pastRepo.save(obj) != null) {
			return "Data Added";
		}
		return "Invalid Request";
	}

	public String update(SparePart obj) {
		if(pastRepo.save(obj) != null) 
			return "Data Added";
		return "Invalid Request";
	}

	public void delete(Long id) {
		pastRepo.deleteById(id);
	}
}
