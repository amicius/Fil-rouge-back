package fr.dta.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.dto.GamePaging;
import fr.dta.dto.PostGame;
import fr.dta.service.GameService;

@RestController
@CrossOrigin
@RequestMapping("/visitor")
public class VisitorController {

	@Autowired
	GameService gameService;

	@GetMapping
	public ResponseEntity<GamePaging> findAllGames(HttpServletRequest request) {

		Integer page = Integer.parseInt(request.getHeader("page"));
		return this.gameService.findAllGames(page);
	}

	@PostMapping
	public ResponseEntity<GamePaging> findGamesVisitor(HttpServletRequest request, @RequestBody PostGame game) {

		Integer page = Integer.parseInt(request.getHeader("page"));
		return this.gameService.findGamesVisitor(page, game);
	}
}
