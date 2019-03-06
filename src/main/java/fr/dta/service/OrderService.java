package fr.dta.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import fr.dta.entity.Order;
import fr.dta.entity.OrderPaging;
import fr.dta.repository.OrderRepository;
import fr.dta.repository.OrderRepositoryImpl;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderRepositoryImpl orderRepositoryImpl;

	public void save(@Valid Order order) {

		order.getGames().forEach(pc -> pc.getId().setOrder(order));
		orderRepository.save(order);
	}

	public ResponseEntity<OrderPaging> findAllOrders(int page) {

		OrderPaging foundOrder = orderRepositoryImpl.findAllOrders(page);
		if (foundOrder != null) {
			return new ResponseEntity<>(foundOrder, HttpStatus.OK);
		}
		return ResponseEntity.badRequest().build();
	}
}
