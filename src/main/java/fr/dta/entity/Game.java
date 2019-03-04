package fr.dta.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "game")
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

	public Game(String name, Plateform plateform, Genre genre, long price, String image, String description, int stock,
			String editor, Date date, boolean active) {

		super(name, plateform, price);
		this.genre = genre;
		this.image = image;
		this.description = description;
		this.stock = stock;
		this.editor = editor;
		this.date = date;
		this.active = active;
	}

	@Override
	public String toString() {
		return super.toString() + "Game [genre=" + genre + ", image=" + image + ", description=" + description
				+ ", stock=" + stock + ", editor=" + editor + ", date=" + date + ", active=" + active + "]";
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

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
