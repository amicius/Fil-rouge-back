package fr.dta.dto;

public class PostOrder {

	private String firstname;
	private String lastname;
	private String numeroClient;

	public PostOrder() {
		super();
	}

	public PostOrder(String firstname, String lastname, String numeroClient) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.numeroClient = numeroClient;
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

	public String getNumeroClient() {
		return numeroClient;
	}

	public void setNumeroClient(String numeroClient) {
		this.numeroClient = numeroClient;
	}
}
