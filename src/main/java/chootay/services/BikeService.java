package chootay.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chootay.model.BikeRecord;
import chootay.repos.BikeRepo;

@Service
public class BikeService {

	@Autowired
	private BikeRepo bikeRepo;
	
	public List<BikeRecord> getAll(){
		List<BikeRecord> obj =new ArrayList<>();
		bikeRepo.findAll().forEach(obj::add);
		return obj;
	}
	
	public Optional<BikeRecord> get(Long id) {
		return bikeRepo.findById(id);
	}

	public String add(BikeRecord obj) {
		if(bikeRepo.save(obj) != null) {
			return "Data Added";
		}
		return "Invalid Request";
	}

	public String update(BikeRecord obj) {
		if(bikeRepo.save(obj) != null) 
			return "Data Added";
		return "Invalid Request";
	}

	public void delete(Long id) {
		bikeRepo.deleteById(id);
	}
}
