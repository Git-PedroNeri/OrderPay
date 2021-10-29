package br.com.neri.pedro.orderpay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.neri.pedro.orderpay.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
