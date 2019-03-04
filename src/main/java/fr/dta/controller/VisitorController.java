package fr.dta.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.entity.GamePaging;
import fr.dta.service.GameService;

@RestController
@CrossOrigin
@RequestMapping("/visitor")
public class VisitorController {

	@Autowired
	GameService gameService;

	@GetMapping
	public ResponseEntity<GamePaging> findGames(HttpServletRequest request) {

		Integer page = Integer.parseInt(request.getHeader("page"));
		return this.gameService.findAllGames(page);
	}
}
