package fr.dta.repository;

import org.springframework.stereotype.Repository;

import fr.dta.dto.GamePaging;
import fr.dta.dto.PostGame;

@Repository
public interface GameRepositoryCustom {

	GamePaging findGames(int start, PostGame game);

	GamePaging findAllGames(int page);

	GamePaging findGamesVisitor(Integer page, PostGame game);
}
