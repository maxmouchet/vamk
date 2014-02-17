package vamk.java.assignment4;

public class Item {

	private static int lastId = 0;

	private int id;
	private String name;
	private float price;

	public Item(String name, float price) {
		this.id = lastId++;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public Item getItem(int id) {
		return this.id == id ? this : null;
	}

	public Item getItem(String name) {
		return this.name.equals(name) ? this : null;
	}
	
	public void setPrice(int id, float price) {
		if (this.id == id) { this.price = price; }
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}
