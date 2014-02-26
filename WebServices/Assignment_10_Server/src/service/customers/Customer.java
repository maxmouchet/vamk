package service.customers;

public class Customer {

	private String id;
	private String name;

	private Float purchase;

	public Customer() {
		this.id = null;
		this.name = null;
		this.purchase = null;
	}

	public Customer(String id, String name, Float purchase) {
		this.id = id;
		this.name = name;
		this.purchase = purchase;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPurchase(Float purchase) {
		this.purchase = purchase;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Float getPurchase() {
		return purchase;
	}

}
