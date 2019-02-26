package fr.dta.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "_user")
public class User extends UserLight {

	private String email;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, Credential credential) {
		super(username, password, credential);
		// TODO Auto-generated constructor stub
	}

}
