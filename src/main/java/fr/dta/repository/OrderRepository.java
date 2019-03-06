package fr.dta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dta.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
