package fr.dta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import fr.dta.entity.Game;
import fr.dta.entity.GameLight;
import fr.dta.repository.GameRepository;
import fr.dta.repository.GameRepositoryImpl;

@Service
public class GameService {

	@Autowired
	GameRepository gameRepository;

	@Autowired
	GameRepositoryImpl gameRepositoryImpl;

	public Game save(Game game) {

		return gameRepository.save(game);
	}

	// @PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<List<Game>> findGames(int start, GameLight game) {

		List<Game> foundGame = gameRepositoryImpl.findGames(1, game);
		if (foundGame != null) {
			return new ResponseEntity<>(foundGame, HttpStatus.OK);
		}
		return ResponseEntity.badRequest().build();
	}
}
