package co.edu.uelbosque.GenericStore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uelbosque.GenericStore.model.Product;
import co.edu.uelbosque.GenericStore.repository.ProductRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductRepository productRepo;

	@PostMapping("/users")
	public ResponseEntity<Product> createTutorial(@RequestBody Product product) {
		try {
			Product _product = productRepo.save(new Product(product.getCode(), product.getNitSupplier(),
					product.getName(), product.getPurchasePrice()));
			return new ResponseEntity<>(_product, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/users")
	public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) int code) {
		try {
			List<Product> products = new ArrayList<Product>();

			if (code == 0)
				productRepo.findAll().forEach(products::add);
			else
				productRepo.findByCode(code).forEach(products::add);

			if (products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
