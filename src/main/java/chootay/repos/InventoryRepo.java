package chootay.repos;

import org.springframework.data.repository.CrudRepository;

import chootay.model.Inventory;

public interface InventoryRepo extends CrudRepository<Inventory, Long> {

}
