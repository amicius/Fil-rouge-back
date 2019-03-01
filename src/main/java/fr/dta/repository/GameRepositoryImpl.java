package fr.dta.repository;

import java.util.List;

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

import fr.dta.entity.Game;
import fr.dta.entity.GameLight;

@Repository
public class GameRepositoryImpl implements GameRepositoryCustom {

	private EntityManager entityManager;

	@Autowired
	public void setJpaContext(JpaContext jpaContext) {
		this.entityManager = jpaContext.getEntityManagerByManagedType(Game.class);
	}

	@Override
	// @PreAuthorize("hasAuthority('ADMIN')")
	public List<Game> findGames(int numPage, GameLight game) {

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
//		if (!StringUtils.isEmpty(Long.valueOf(game.getPrice()))) {
//			pricePredicate = builder.like(builder.upper(root.get("price")), "%" + Long.valueOf(game.getPrice()) + "%");
//		}
		if (!StringUtils.isEmpty(game.getReference())) {
			referencePredicate = builder.like(builder.upper(root.get("reference")),
					"%" + game.getReference().toUpperCase() + "%");
		}

		query.where(builder.and(namePredicate, plateformPredicate, pricePredicate, referencePredicate));

		TypedQuery<Game> gameQuery = entityManager.createQuery(query);
		gameQuery.setFirstResult((numPage - 1) * 10);
		gameQuery.setMaxResults(10);
		return gameQuery.getResultList();
	}
}
