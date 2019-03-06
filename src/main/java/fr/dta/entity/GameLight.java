package fr.dta.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@MappedSuperclass
@SequenceGenerator(name = "game_seq")
public class GameLight {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_seq")
	private Integer id;

	@Column(nullable = false)
	private String name;

	@Column
	private Plateform plateform;

	@Column(nullable = false)
	private long price;

	@Column
	private String reference;

	public GameLight() {
		super();
	}

	public GameLight(String name, Plateform plateform, long price) {

		super();
		this.name = name;
		this.plateform = plateform;
		this.price = price;
	}

	public GameLight(Integer id, String name, Plateform plateform, long price) {

		super();
		this.id = id;
		this.name = name;
		this.plateform = plateform;
		this.price = price;
	}

	@Override
	public String toString() {
		return "GameLight [id=" + id + ", name=" + name + ", plateform=" + plateform + ", price=" + price
				+ ", reference=" + reference + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getReference() {
		return reference;
	}

	public void setReference() {
		this.reference = this.id + "_" + this.name.toLowerCase().replaceAll(" ", "_");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((plateform == null) ? 0 : plateform.hashCode());
		result = prime * result + (int) (price ^ (price >>> 32));
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameLight other = (GameLight) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (plateform != other.plateform)
			return false;
		if (price != other.price)
			return false;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		return true;
	}
}
