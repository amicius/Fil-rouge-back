package fr.dta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import fr.dta.dto.GamePaging;
import fr.dta.dto.PostGame;
import fr.dta.entity.Game;
import fr.dta.repository.GameRepository;
import fr.dta.repository.GameRepositoryImpl;

@Service
public class GameService {

	@Autowired
	GameRepository gameRepository;

	@Autowired
	GameRepositoryImpl gameRepositoryImpl;

	public Game save(Game game) {

		gameRepository.save(game);
		game.setReference();
		return gameRepository.save(game);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<GamePaging> findGames(int page, PostGame game) {

		GamePaging foundGame = gameRepositoryImpl.findGames(page, game);
		if (foundGame != null) {
			return new ResponseEntity<>(foundGame, HttpStatus.OK);
		}
		return ResponseEntity.badRequest().build();
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	public Game update(Game game) {

		return gameRepository.save(game);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	public void delete(int id) {

		gameRepository.deleteById(id);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	public Game activateDeactivateGame(Game game) {

		game.setActive(!game.getActive());
		return gameRepository.save(game);
	}

	public ResponseEntity<GamePaging> findAllGames(Integer page) {

		GamePaging foundGame = gameRepositoryImpl.findAllGames(page);
		if (foundGame != null) {
			return new ResponseEntity<>(foundGame, HttpStatus.OK);
		}
		return ResponseEntity.badRequest().build();
	}

	public ResponseEntity<GamePaging> findGamesVisitor(Integer page, PostGame game) {

		GamePaging foundGame = gameRepositoryImpl.findGamesVisitor(page, game);
		if (foundGame != null) {
			return new ResponseEntity<>(foundGame, HttpStatus.OK);
		}
		return ResponseEntity.badRequest().build();
	}

	public Game findOneGame(String name) {

		return gameRepository.findByName(name);
	}
}
