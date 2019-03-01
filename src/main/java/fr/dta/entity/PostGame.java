package fr.dta.entity;

public class PostGame {

	private String name;

	private String plateform;

	private Integer price;

	private String reference;

	public PostGame() {
	}

	public PostGame(String name, String plateform, Integer price, String reference) {
		super();
		this.name = name;
		this.plateform = plateform;
		this.price = price;
		this.reference = reference;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlateform() {
		return plateform;
	}

	public void setPlateform(String plateform) {
		this.plateform = plateform;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
}
