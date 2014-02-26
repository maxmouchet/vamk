package vamk.java.assignment5;

public class Purchase {
	
	private static int lastId = 0;

	private int id;
	private int itemId;
	private int amount;
	
	public Purchase(int itemId, int amount) {
		this.id = lastId++;
		this.itemId = itemId;
		this.amount = amount;
	}

	public Purchase getPurchase(int id) {
		return this.id == id ? this : null;
	}
	
	public int getItemId() {
		return itemId;
	}
	
	public int getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", itemId=" + itemId + ", amount="
				+ amount + "]";
	}

}
