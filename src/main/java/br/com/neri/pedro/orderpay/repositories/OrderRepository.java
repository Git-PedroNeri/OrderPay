package br.com.neri.pedro.orderpay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.neri.pedro.orderpay.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
