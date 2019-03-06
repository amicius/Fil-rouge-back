package fr.dta.entity;

import java.util.List;

public class OrderPaging {

	private int pages;
	private List<Order> orders;

	public OrderPaging() {
	}

	public OrderPaging(int pages, List<Order> orders) {
		super();
		this.pages = pages;
		this.orders = orders;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
