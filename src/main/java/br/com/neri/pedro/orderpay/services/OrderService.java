package br.com.neri.pedro.orderpay.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neri.pedro.orderpay.entities.Order;
import br.com.neri.pedro.orderpay.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository OrderRep;

	public List<Order> findAll() {
		return OrderRep.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> optionalOrder = OrderRep.findById(id);
		return optionalOrder.get();
	}

}
