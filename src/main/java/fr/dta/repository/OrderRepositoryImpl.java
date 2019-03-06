package fr.dta.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;

import fr.dta.entity.Game;
import fr.dta.entity.Order;
import fr.dta.entity.OrderPaging;

public class OrderRepositoryImpl implements OrderRepositoryCustom {

	private EntityManager entityManager;

	@Autowired
	public void setJpaContext(JpaContext jpaContext) {
		this.entityManager = jpaContext.getEntityManagerByManagedType(Game.class);
	}

	@Override
	public OrderPaging findAllOrders(int page) {

		OrderPaging foundOrders;
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Order> query = builder.createQuery(Order.class);

		TypedQuery<Order> orderQuery = entityManager.createQuery(query);
		int pages = orderQuery.getResultList().size();
		orderQuery.setFirstResult((page - 1) * 10);
		orderQuery.setMaxResults(10);

		foundOrders = new OrderPaging(pages, orderQuery.getResultList());
		return foundOrders;
	}
}
