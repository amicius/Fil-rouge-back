package fr.dta.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jeu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String nom;
	
	@Column
	private Plateforme plateforme;
	
	@Column
	private Genre genre;
	
	@Column(nullable = false)
	private double prix;
	
	@Column
	private String image;
	
	@Column
	private String description;
	
	@Column(nullable = false)
	private String reference;
	
	@Column(nullable = false)
	private int stock;
	
	@Column
	private String editeur;
	
	@Column
	private Date dateParution;
	
	@Column
	private boolean actif;

}
