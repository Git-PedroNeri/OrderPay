package br.com.neri.pedro.orderpay.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.neri.pedro.orderpay.entities.Product;
import br.com.neri.pedro.orderpay.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	@Autowired
	ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> products = productService.findAllProducts();
		return ResponseEntity.ok().body(products);

	}

	// Metodo para retornar um Produto passando o id como paramentro
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product product = productService.findProductById(id);
		return ResponseEntity.ok().body(product);
	}

}
