package fr.dta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import fr.dta.entity.Game;
import fr.dta.repository.GameRepository;

@Service
public class GameService {

	@Autowired
	GameRepository gameRepository;

	public Game save(Game game) {

		return gameRepository.save(game);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	public List<Game> findAll(int start) {

		List<Game> listRet = new ArrayList<>();
		listRet = gameRepository.findAll();
//		listRet.stream().reduce(start)
		return null;
	}
}
