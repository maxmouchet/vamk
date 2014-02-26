package vamk.java.assignment5;

import java.util.Arrays;

public class Shop {

	private static int lastId = 0;

	private int id;
	private String name;
	private String address;
	private String phone;
	private Item[] items;

	public Shop(String name, String address, String phone, Item[] items) {
		this.id = lastId++;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.items = items;
	}

	public String getItem(int id) {
		Item item = null;
		Boolean found = false;

		for (int i = 0; i < items.length && !found; i++) {
			if (items[i].getId() == id) {
				item = items[i];
				found = true;
			}
		}

		return item != null ? item.toString() : "";
	}

	public String getItem(String name) {
		Item item = null;
		Boolean found = false;

		for (int i = 0; i < items.length && !found; i++) {
			if (items[i].getName().equals(name)) {
				item = items[i];
				found = true;
			}
		}

		return item != null ? item.toString() : "";
	}
	
	public void addItem(Item item) {
		items = Arrays.copyOf(items, items.length + 1);
		items[items.length - 1] = item;
	}

	@Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + ", address=" + address
				+ ", phone=" + phone + ", items=" + Arrays.toString(items)
				+ "]";
	}

}
