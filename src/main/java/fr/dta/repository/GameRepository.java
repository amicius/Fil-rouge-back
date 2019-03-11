package fr.dta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dta.entity.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {

	Game findByActive(boolean active);

	Game findByName(String name);
}
