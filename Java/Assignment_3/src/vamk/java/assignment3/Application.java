package vamk.java.assignment3;

public class Application {

	public static void main(String[] args) {
		// Create a test shop
		Item milk = new Item("Milk", 10.35f);
		Item cheese = new Item("Cheese", 15f);

		Item[] items = { milk, cheese };

		Shop supermarket = new Shop("Supermarket", "+358123456789", items);

		// Test methods
		System.out.println(supermarket.toString());
		System.out.println(supermarket.getItem(1));

	}

}
