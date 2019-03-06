package fr.dta.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dta.entity.Order;
import fr.dta.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	public void save(@Valid Order order) {

		order.getGames().forEach(pc -> pc.getId().setOrder(order));
		orderRepository.save(order);
	}

}
