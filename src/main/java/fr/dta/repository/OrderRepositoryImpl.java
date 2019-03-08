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

	public OrderPaging findAllOrders(Integer page, PostOrder order) {

		OrderPaging foundGames;
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Order> query = builder.createQuery(Order.class);
		Root<Order> root = query.from(Order.class);
		Join<Order, User> userJoin = root.join("user");

		Predicate firstnamePredicate = builder.and();
		Predicate lastnamePredicate = builder.and();
		Predicate numeroPredicate = builder.and();
		Predicate startDatePredicate = builder.and();
		Predicate endDatePredicate = builder.and();

		if (!StringUtils.isEmpty(order.getFirstname())) {
			firstnamePredicate = builder.equal(builder.upper(userJoin.get("firstname")), order.getFirstname());
		}
		if (!StringUtils.isEmpty(order.getLastname())) {
			lastnamePredicate = builder.equal(builder.upper(userJoin.get("lastname")), order.getLastname());
		}
		if (!StringUtils.isEmpty(order.getOrderNum())) {
			numeroPredicate = builder.equal(builder.upper(root.get("id")), order.getOrderNum());
		}
		if (!StringUtils.isEmpty(order.getStartDate())) {
			startDatePredicate = builder.greaterThanOrEqualTo(builder.upper(root.get("orderDate")),
					"%" + order.getStartDate() + "%");
		}
		if (!StringUtils.isEmpty(order.getEndDate())) {
			endDatePredicate = builder.lessThanOrEqualTo(builder.upper(root.get("orderDate")),
					"%" + order.getEndDate() + "%");
		}

		query.where(builder.and(firstnamePredicate, lastnamePredicate, numeroPredicate, startDatePredicate,
				endDatePredicate));

		TypedQuery<Order> orderQuery = entityManager.createQuery(query);
		int pages = orderQuery.getResultList().size();
		orderQuery.setFirstResult((page - 1) * 10);
		orderQuery.setMaxResults(10);

		foundGames = new OrderPaging(pages, orderQuery.getResultList());
		return foundGames;
	}
}
