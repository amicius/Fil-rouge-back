package fr.dta.repository;

import fr.dta.dto.OrderPaging;

public interface OrderRepositoryCustom {

	OrderPaging findAllOrdersByUserId(int start, Integer id);
}
