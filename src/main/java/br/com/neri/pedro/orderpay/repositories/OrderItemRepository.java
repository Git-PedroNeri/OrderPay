package br.com.neri.pedro.orderpay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.neri.pedro.orderpay.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
