package fr.dta.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import fr.dta.dto.OrderPaging;
import fr.dta.dto.PostOrder;
import fr.dta.entity.Game;
import fr.dta.entity.Order;
import fr.dta.entity.User;
import fr.dta.repository.GameRepository;
import fr.dta.repository.OrderRepository;
import fr.dta.repository.OrderRepositoryImpl;
import fr.dta.repository.UserRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderRepositoryImpl orderRepositoryImpl;

	@Autowired
	GameRepository gameRepository;

	@Autowired
	UserRepository userRepository;

	public void save(@Valid Order order) {

		order.getGames().forEach(pc -> pc.getId().setOrder(order));
		orderRepository.save(order);
		order.getGames().forEach(pc -> {
			Game game = pc.getGame();
			game.setStock(game.getStock() - pc.getQuantity());
			gameRepository.save(game);
		});
	}

	public ResponseEntity<OrderPaging> findAllOrdersByUserId(int page, Integer id) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String principalId = auth.getName();
		User user = userRepository.findById(id).get();

		if (principalId.equals(user.getUsername())) {

			OrderPaging foundOrder = orderRepositoryImpl.findAllOrdersByUserId(page, id);
			if (foundOrder != null) {

				return new ResponseEntity<>(foundOrder, HttpStatus.OK);
			}
		}
		return ResponseEntity.badRequest().build();
	}

	public ResponseEntity<OrderPaging> findAllOrders(Integer page, PostOrder order) {

		OrderPaging foundOrder = orderRepositoryImpl.findAllOrders(page, order);
		if (foundOrder != null) {
			return new ResponseEntity<>(foundOrder, HttpStatus.OK);
		}
		return ResponseEntity.badRequest().build();
	}
}
