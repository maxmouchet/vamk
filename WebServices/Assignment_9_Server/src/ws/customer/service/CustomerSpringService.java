package ws.customer.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import ws.customer.data.Customer;

public class CustomerSpringService {
	LinkedHashMap<String, Customer> customers;

	public void setCustomers(LinkedHashMap<String, Customer> customers) {
		this.customers = customers;
	}

	public LinkedHashMap<String, Customer> getCustomers() {
		return customers;
	}

	public Object[] getCustomerIds() {
		ArrayList<Integer> customerIds = new ArrayList<Integer>();

		for (Customer customer : customers.values()) {
			customerIds.add(customer.getCustomerID());
		}

		return customerIds.toArray();
	}

	public Customer getCustomerByID(int id) {
		return customers.get(String.valueOf(id));
	}

	public Customer getCustomerWithLargestAmount() {
		Customer result = new Customer();

		for (Customer customer : customers.values()) {
			if (customer.getShoppingAmount() > result.getShoppingAmount()) {
				result = customer;
			}
		}

		return result;
	}
	
	public Object[] getCustomersByType(Boolean privileged) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for (Customer customer : customers.values()) {
			if (customer.getPrivileged() == privileged) {
				result.add(customer.getCustomerID());
			}
		}
		
		return result.toArray();
	}
}