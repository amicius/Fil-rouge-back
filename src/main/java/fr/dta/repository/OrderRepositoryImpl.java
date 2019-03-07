package fr.dta.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.util.StringUtils;

import fr.dta.dto.OrderPaging;
import fr.dta.dto.PostOrder;
import fr.dta.entity.Game;
import fr.dta.entity.Order;
import fr.dta.entity.User;

public class OrderRepositoryImpl implements OrderRepositoryCustom {

	private EntityManager entityManager;

	@Autowired
	public void setJpaContext(JpaContext jpaContext) {
		this.entityManager = jpaContext.getEntityManagerByManagedType(Game.class);
	}

	@Override
	public OrderPaging findAllOrdersByUserId(int page, Integer id) {

		OrderPaging foundOrders;
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Order> query = builder.createQuery(Order.class);
		Root<Order> root = query.from(Order.class);
		Join<Order, User> userJoin = root.join("user");

		Predicate userPredicate = builder.and();

		userPredicate = builder.equal(builder.upper(userJoin.get("id")), id);

		query.where(builder.and(userPredicate));

		TypedQuery<Order> orderQuery = entityManager.createQuery(query);
		int pages = orderQuery.getResultList().size();
		orderQuery.setFirstResult((page - 1) * 10);
		orderQuery.setMaxResults(10);

		foundOrders = new OrderPaging(pages, orderQuery.getResultList());
		return foundOrders;
	}

	public OrderPaging findOrdersRegister(Integer page, PostOrder order) {

		OrderPaging foundGames;
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Order> query = builder.createQuery(Order.class);
		Root<Order> root = query.from(Order.class);

		Predicate firstnamePredicate = builder.and();
		Predicate lastnamePredicate = builder.and();
		Predicate numeroPredicate = builder.and();

		if (!StringUtils.isEmpty(order.getFirstname())) {
			firstnamePredicate = builder.like(builder.upper(root.get("user.firstname")),
					"%" + order.getFirstname().toUpperCase() + "%");
		}
		if (!StringUtils.isEmpty(order.getLastname())) {
			lastnamePredicate = builder.like(builder.upper(root.get("user.lastname")),
					"%" + order.getLastname().toUpperCase() + "%");
		}
		if (!StringUtils.isEmpty(order.getNumeroClient())) {
			numeroPredicate = builder.equal(builder.upper(root.get("numeroClient")), order.getNumeroClient());
		}

		query.where(builder.and(firstnamePredicate, lastnamePredicate, numeroPredicate));

		TypedQuery<Order> orderQuery = entityManager.createQuery(query);
		int pages = orderQuery.getResultList().size();
		orderQuery.setFirstResult((page - 1) * 10);
		orderQuery.setMaxResults(10);

		foundGames = new OrderPaging(pages, orderQuery.getResultList());
		return foundGames;
	}
}
