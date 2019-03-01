package fr.dta.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "_user")
public class User extends UserLight {

	@Column
	private String firstname;

	@Column
	private String lastname;

	@Column
	private String adress;

	@Column
	private String phone;

	@Column
	private String email;

	@Column
	private Date birthday;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, Credential credential) {

		super(username, password, credential);
	}

	public User(String username, String password, Credential credential, String firstname, String lastname,
			String adress, String phone, String email, Date birthday) {

		super(username, password, credential);
		this.firstname = firstname;
		this.lastname = lastname;
		this.adress = adress;
		this.phone = phone;
		this.email = email;
		this.birthday = birthday;
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public UserLight toUserLight() {

		return new UserLight(this.getUsername(), this.getPassword(), this.getCredential());
	}
}
