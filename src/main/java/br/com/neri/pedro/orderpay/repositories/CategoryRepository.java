package br.com.neri.pedro.orderpay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.neri.pedro.orderpay.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
