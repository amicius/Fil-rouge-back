package fr.dta.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import fr.dta.dto.GamePaging;
import fr.dta.dto.PostGame;
import fr.dta.entity.Game;

@Repository
public class GameRepositoryImpl implements GameRepositoryCustom {

	private EntityManager entityManager;

	@Autowired
	public void setJpaContext(JpaContext jpaContext) {
		this.entityManager = jpaContext.getEntityManagerByManagedType(Game.class);
	}

	@Override
	// @PreAuthorize("hasAuthority('ADMIN')")
	public GamePaging findGames(int page, PostGame game) {

		GamePaging foundGames;
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Game> query = builder.createQuery(Game.class);
		Root<Game> root = query.from(Game.class);

		Predicate namePredicate = builder.and();
		Predicate plateformPredicate = builder.and();
		Predicate pricePredicate = builder.and();
		Predicate referencePredicate = builder.and();

		if (!StringUtils.isEmpty(game.getName())) {
			namePredicate = builder.like(builder.upper(root.get("name")), "%" + game.getName().toUpperCase() + "%");
		}
		if (!StringUtils.isEmpty(game.getPlateform())) {
			plateformPredicate = builder.like(builder.upper(root.get("plateform")),
					"%" + game.getPlateform().toString() + "%");
		}
//		if (!StringUtils.isEmpty((game.getPrice()))) {
//			pricePredicate = builder.like(builder.upper(root.get("price")), "%" + game.getPrice().toString() + "%");
//		}
		if (!StringUtils.isEmpty(game.getReference())) {
			referencePredicate = builder.like(builder.upper(root.get("reference")),
					"%" + game.getReference().toUpperCase() + "%");
		}

		query.where(builder.and(namePredicate, plateformPredicate, pricePredicate, referencePredicate));

		TypedQuery<Game> gameQuery = entityManager.createQuery(query);
		int pages = gameQuery.getResultList().size();
		gameQuery.setFirstResult((page - 1) * 10);
		gameQuery.setMaxResults(10);

		foundGames = new GamePaging(pages, gameQuery.getResultList());
		return foundGames;
	}

	public GamePaging findAllGames(int page) {

		GamePaging foundGames;
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Game> query = builder.createQuery(Game.class);
		Root<Game> root = query.from(Game.class);

		Predicate activePredicate = builder.and();

		activePredicate = builder.isTrue(root.get("active"));

		query.where(builder.and(activePredicate));

		TypedQuery<Game> gameQuery = entityManager.createQuery(query);
		int pages = gameQuery.getResultList().size();
		gameQuery.setFirstResult((page - 1) * 10);
		gameQuery.setMaxResults(10);

		foundGames = new GamePaging(pages, gameQuery.getResultList());
		return foundGames;
	}

	public GamePaging findGamesVisitor(Integer page, PostGame game) {

		GamePaging foundGames;
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Game> query = builder.createQuery(Game.class);
		Root<Game> root = query.from(Game.class);

		Predicate namePredicate = builder.and();
		Predicate plateformPredicate = builder.and();
		Predicate genrePredicate = builder.and();
		Predicate activePredicate = builder.and();

		if (!StringUtils.isEmpty(game.getName())) {
			namePredicate = builder.like(builder.upper(root.get("name")), "%" + game.getName().toUpperCase() + "%");
		}
		if (!StringUtils.isEmpty(game.getPlateform())) {
			plateformPredicate = builder.equal(builder.upper(root.get("plateform")), game.getPlateform());
		}
		if (!StringUtils.isEmpty(game.getGenre())) {
			genrePredicate = builder.equal(builder.upper(root.get("genre")), game.getGenre());
		}
		activePredicate = builder.isTrue(root.get("active"));

		query.where(builder.and(namePredicate, plateformPredicate, genrePredicate, activePredicate));

		TypedQuery<Game> gameQuery = entityManager.createQuery(query);
		int pages = gameQuery.getResultList().size();
		gameQuery.setFirstResult((page - 1) * 10);
		gameQuery.setMaxResults(10);

		foundGames = new GamePaging(pages, gameQuery.getResultList());
		return foundGames;
	}
}
