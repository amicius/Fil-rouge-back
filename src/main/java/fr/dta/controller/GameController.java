package fr.dta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.dto.GamePaging;
import fr.dta.dto.PostGame;
import fr.dta.entity.Game;
import fr.dta.service.GameService;

@RestController
@CrossOrigin
@RequestMapping("/game")
public class GameController {

	@Autowired
	GameService gameService;

	@PostMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody @Valid Game game) {
		gameService.save(game);
	}

	@PostMapping("/search")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<GamePaging> findGames(HttpServletRequest request, @RequestBody PostGame game) {

		Integer page = Integer.parseInt(request.getHeader("page"));
		return this.gameService.findGames(page, game);
	}

	@PutMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public Game updateGame(@RequestBody Game game) {

		return this.gameService.update(game);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public void deleteGame(@PathVariable int id) {

		this.gameService.delete(id);
	}

	@PutMapping("/activation")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Game activateDeactivateGame(@RequestBody Game game) {

		return gameService.activateDeactivateGame(game);
	}

	@GetMapping
	public Game findOneGame(HttpServletRequest request) {

		String name = request.getHeader("name");
		return gameService.findOneGame(name);
	}
}
