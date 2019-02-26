package fr.dta.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "_user")
public class User extends UserLight {

	private String email;

}
