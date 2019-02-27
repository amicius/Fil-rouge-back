package fr.dta.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String nom;
	
	@Column
	private Plateform plateforme;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Plateform getPlateforme() {
		return plateforme;
	}

	public void setPlateforme(Plateform plateforme) {
		this.plateforme = plateforme;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public Date getDateParution() {
		return dateParution;
	}

	public void setDateParution(Date dateParution) {
		this.dateParution = dateParution;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Game(int id, String nom, Plateform plateforme, Genre genre, double prix, String image, String description,
			String reference, int stock, String editeur, Date dateParution, boolean actif) {
		this.id = id;
		this.nom = nom;
		this.plateforme = plateforme;
		this.genre = genre;
		this.prix = prix;
		this.image = image;
		this.description = description;
		this.reference = reference;
		this.stock = stock;
		this.editeur = editeur;
		this.dateParution = dateParution;
		this.actif = actif;
	}

	public Game(String nom, Plateform plateforme, Genre genre, double prix, String image, String description,
			String reference, int stock, String editeur, Date dateParution, boolean actif) {
		this.nom = nom;
		this.plateforme = plateforme;
		this.genre = genre;
		this.prix = prix;
		this.image = image;
		this.description = description;
		this.reference = reference;
		this.stock = stock;
		this.editeur = editeur;
		this.dateParution = dateParution;
		this.actif = actif;
	}

	public Game() {
	}
	
}
