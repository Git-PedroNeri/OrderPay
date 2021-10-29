package br.com.neri.pedro.orderpay.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neri.pedro.orderpay.entities.Product;
import br.com.neri.pedro.orderpay.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	public Product findProductById(Long id) {
		Optional<Product> optProduct = productRepository.findById(id);
		return optProduct.get();
	}

}
