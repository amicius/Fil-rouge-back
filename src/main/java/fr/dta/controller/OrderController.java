package fr.dta.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.entity.Order;
import fr.dta.service.OrderService;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping
	@PreAuthorize("hasAuthority('REGISTER')")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody @Valid Order order) {
		orderService.save(order);
	}
}
