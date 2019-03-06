package fr.dta.repository;

import fr.dta.entity.OrderPaging;

public interface OrderRepositoryCustom {

	OrderPaging findAllOrders(int start);
}
