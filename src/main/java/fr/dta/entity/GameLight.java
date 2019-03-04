package fr.dta.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class GameLight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
