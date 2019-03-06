package fr.dta.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@JsonIgnore
	@OneToMany(mappedBy = "id.game")
	private List<GameOrder> gameOrder;

	public Game() {
		super();
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

	public List<GameOrder> getGameOrder() {
		return gameOrder;
	}

	public void setGameOrder(List<GameOrder> gameOrder) {
		this.gameOrder = gameOrder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((editor == null) ? 0 : editor.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + stock;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (active != other.active)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (editor == null) {
			if (other.editor != null)
				return false;
		} else if (!editor.equals(other.editor))
			return false;
		if (genre != other.genre)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (stock != other.stock)
			return false;
		return true;
	}
}
