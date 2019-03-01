package fr.dta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.entity.Game;
import fr.dta.entity.GameLight;
import fr.dta.entity.GamePaging;
import fr.dta.service.GameService;

@RestController
@CrossOrigin
public class GameController {

	@Autowired
	GameService gameService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody @Valid Game game) {

		gameService.save(game);
	}

	@PostMapping("/game")
	// @PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<GamePaging> findGames(HttpServletRequest request, @RequestBody GameLight game) {

		int page = Integer.parseInt(request.getHeader("page"));
		return this.gameService.findGames(page, game);
	}

	@PatchMapping("/{name}")
	public Game updateGame(@RequestBody Game game) {

		return this.gameService.updateScore(game);
	}
}
