package chootay.repos;

import org.springframework.data.repository.CrudRepository;

import chootay.model.customer;

public interface CustomerRepo extends CrudRepository<customer,Long>{

}
