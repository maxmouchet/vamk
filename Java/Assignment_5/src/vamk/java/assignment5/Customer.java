package vamk.java.assignment5;

import java.util.Arrays;

public class Customer {

	private static int lastId = 0;

	private int id;
	private String name;
	private String phone;
	private Purchase[] purchases;
	
	public Customer(String name, String phone, Purchase[] purchases) {
		this.id = lastId;
		this.name = name;
		this.phone = phone;
		this.purchases = purchases;
	}
	
	public Customer getCustomer(int id) {
		return this.id == id ? this : null;
	}
	
	public Purchase[] getPurchases() {
		return purchases;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone
				+ ", purchases=" + Arrays.toString(purchases) + "]";
	}
	
	
}
