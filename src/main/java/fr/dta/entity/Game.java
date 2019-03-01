package fr.dta.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Game extends GameLight {

	@Column
	private Genre genre;

	@Column
	private String image;

	@Column
	private String description;

	@Column(nullable = false)
	private int stock;

	@Column
	private String editor;

	@Column
	private Date date;

	@Column
	private boolean active;

	public Game() {
	}

	public Game(String name, Plateform plateform, Genre genre, long price, String image, String description,
			String reference, int stock, String editor, Date date, boolean active) {

		super(name, plateform, price, reference);
		this.genre = genre;
		this.image = image;
		this.description = description;
		this.stock = stock;
		this.editor = editor;
		this.date = date;
		this.active = active;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
