package ws.customer.data;

public class Customer {

	String customerName;
	Integer customerID;
	float shoppingAmount;
	boolean privileged;
	int discountPercentage;

	// float discount;

	public Customer() {
		customerName = "Customer not knowm";
		customerID = 0;
		shoppingAmount = 0.0f;
		privileged = false;
		discountPercentage = 0;
		// discount=0.0f;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setShoppingAmount(float shoppingAmount) {
		this.shoppingAmount = shoppingAmount;
	}

	public float getShoppingAmount() {
		return shoppingAmount;
	}

	public void setPrivileged(boolean privilleged) {
		this.privileged = privilleged;
	}

	public boolean getPrivileged() {
		return privileged;
	}

	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public int getDiscountPercentage() {
		return discountPercentage;
	}

	public float getDiscount() {
		return shoppingAmount * discountPercentage / 100.0f;
	}

}