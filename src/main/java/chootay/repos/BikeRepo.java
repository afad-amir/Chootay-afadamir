package chootay.repos;

import org.springframework.data.repository.CrudRepository;

import chootay.model.BikeRecord;

public interface BikeRepo extends CrudRepository<BikeRecord,Long> {

}
