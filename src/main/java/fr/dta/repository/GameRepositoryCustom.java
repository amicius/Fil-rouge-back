package fr.dta.repository;

import org.springframework.stereotype.Repository;

import fr.dta.entity.GamePaging;
import fr.dta.entity.PostGame;

@Repository
public interface GameRepositoryCustom {

	GamePaging findGames(int start, PostGame game);
}
