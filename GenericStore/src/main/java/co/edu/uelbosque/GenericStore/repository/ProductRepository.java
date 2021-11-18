package co.edu.uelbosque.GenericStore.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.uelbosque.GenericStore.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

	List<Product> findByCode(int code);
	
}
