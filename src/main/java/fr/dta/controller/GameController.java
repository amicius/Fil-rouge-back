package fr.dta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.entity.Game;
import fr.dta.entity.GamePaging;
import fr.dta.entity.PostGame;
import fr.dta.service.GameService;

@RestController
@CrossOrigin
@RequestMapping("/game")
public class GameController {

	@Autowired
	GameService gameService;

	@PostMapping
	// @PreAuthorize("hasAuthority('REGISTER')")
	// @PreAuthorize("hasAuthority('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody @Valid Game game) {
		gameService.save(game);
	}

	@PostMapping("/search")
	// @PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<GamePaging> findGames(HttpServletRequest request, @RequestBody PostGame game) {

		Integer page = Integer.parseInt(request.getHeader("page"));
		return this.gameService.findGames(page, game);
	}

	@PutMapping
	// @PreAuthorize("hasAuthority('ADMIN')")
	public Game updateGame(@RequestBody Game game) {

		return this.gameService.update(game);
	}

	@DeleteMapping
	// @PreAuthorize("hasAuthority('ADMIN')")
	public void deleteGame(@RequestBody int id) {

		this.gameService.delete(id);
	}

}
