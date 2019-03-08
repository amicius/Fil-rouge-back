package fr.dta.dto;

import java.util.Date;

public class PostOrder {

	private String firstname;
	private String lastname;
	private Integer orderNum;
	private Date startDate;
	private Date endDate;

	public PostOrder() {
		super();
	}

	public PostOrder(String firstname, String lastname, Integer orderNum, Date startDate, Date enDate) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.orderNum = orderNum;
		this.startDate = startDate;
		this.endDate = enDate;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
