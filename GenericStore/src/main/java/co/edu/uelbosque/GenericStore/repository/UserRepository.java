package co.edu.uelbosque.GenericStore.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.uelbosque.GenericStore.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	List<User> findByCode(int code);
	
}
