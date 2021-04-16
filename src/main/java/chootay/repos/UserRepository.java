package chootay.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import chootay.model.users;

@Repository
public interface UserRepository extends CrudRepository<users,Long> {

}
