package vamk.java.assignment4;

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
		
		// Test addItem
		Item pastas = new Item("Pastas", 3.05f);
		supermarket.addItem(pastas);
		System.out.println(supermarket.toString());
		
		// Test setPrice
		pastas.setPrice(2, 4.50f);
		System.out.println(pastas.toString());

	}

}
