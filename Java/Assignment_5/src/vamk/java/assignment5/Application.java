package vamk.java.assignment5;

public class Application {

	public static void main(String[] args) {
		// Create a test shop
		Item milk = new Item("Milk", 10.35f);
		Item cheese = new Item("Cheese", 15f);

		Item[] items = { milk, cheese };

		Shop supermarket = new Shop("Supermarket", "Street 1", "+358123456789", items);
		
		Purchase twoCheeses = new Purchase(0, 2);
		Purchase oneMilk = new Purchase(1, 1);
		
		Purchase[] purchases = { twoCheeses, oneMilk };
		
		Customer mike = new Customer("Mike", "+358987654321", purchases);
		
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

		// Test customer
		System.out.println(mike.toString());
		for (Purchase purchase : mike.getPurchases()) {
			System.out.println(purchase.getAmount() + "x " + supermarket.getItem(purchase.getItemId()).toString());
		}
	}

}
