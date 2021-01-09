package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

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
