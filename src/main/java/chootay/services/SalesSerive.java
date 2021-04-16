package chootay.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chootay.model.Sales;
import chootay.repos.SalesRepo;

@Service
public class SalesSerive {

	@Autowired
	private SalesRepo saleRepo;
	
	public List<Sales> getAll(){
		List<Sales> obj =new ArrayList<>();
		saleRepo.findAll().forEach(obj::add);
		return obj;
	}
	
	public Optional<Sales> get(Long id) {
		return saleRepo.findById(id);
	}

	public String add(Sales obj) {
		if(saleRepo.save(obj) != null) {
			return "Data Added";
		}
		return "Invalid Request";
	}

	public String update(Sales obj) {
		if(saleRepo.save(obj) != null) 
			return "Data Added";
		return "Invalid Request";
	}

	public void delete(Long id) {
		saleRepo.deleteById(id);
	}
}
