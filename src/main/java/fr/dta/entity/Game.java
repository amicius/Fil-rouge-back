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
	private String name;

	@Column
	private Plateform plateform;

	@Column
	private Genre genre;

	@Column(nullable = false)
	private double price;

	@Column
	private String image;

	@Column
	private String description;

	@Column(nullable = false)
	private String reference;

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

	public Game(int id, String name, Plateform plateform, Genre genre, double price, String image, String description,
			String reference, int stock, String editor, Date date, boolean active) {

		this(name, plateform, genre, price, image, description, reference, stock, editor, date, active);
		this.id = id;
	}

	public Game(String name, Plateform plateform, Genre genre, double price, String image, String description,
			String reference, int stock, String editor, Date date, boolean active) {

		this.name = name;
		this.plateform = plateform;
		this.genre = genre;
		this.price = price;
		this.image = image;
		this.description = description;
		this.reference = reference;
		this.stock = stock;
		this.editor = editor;
		this.date = date;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
