package fr.dta.repository;

import fr.dta.entity.GameLight;
import fr.dta.entity.GamePaging;

public interface GameRepositoryCustom {

	GamePaging findGames(int start, GameLight game);
}
