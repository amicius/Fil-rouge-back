package fr.dta.dto;

import fr.dta.entity.Genre;
import fr.dta.entity.Plateform;

public class PostGame {

	private String name;

	private Plateform plateform;

	private String price;

	private String reference;

	private Genre genre;

	public PostGame() {
	}

	public PostGame(String name, Plateform plateform, Genre genre, String price, String reference) {
		super();
		this.name = name;
		this.plateform = plateform;
		this.genre = genre;
		this.price = price;
		this.reference = reference;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Plateform getPlateform() {
		return plateform;
	}

	public void setPlateform(Plateform plateform) {
		this.plateform = plateform;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
}
