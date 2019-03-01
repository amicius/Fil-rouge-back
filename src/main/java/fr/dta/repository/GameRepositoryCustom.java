package fr.dta.repository;

import java.util.List;

import fr.dta.entity.Game;
import fr.dta.entity.GameLight;

public interface GameRepositoryCustom {

	List<Game> findGames(int start, GameLight game);
}
