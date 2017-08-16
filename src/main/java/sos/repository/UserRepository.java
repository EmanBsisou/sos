package sos.repository;

import org.springframework.data.repository.CrudRepository;

import sos.domain.User;

public interface UserRepository extends CrudRepository<User,String>{

	
}
