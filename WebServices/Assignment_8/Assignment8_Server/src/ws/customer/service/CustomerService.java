package ws.customer.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import ws.customer.data.Customer;

public class CustomerService {

	Hashtable<Integer, Customer> customers = new Hashtable<Integer, Customer>();

	private void saveCustomersToXML() {
		try {
			Serializer serializer = new Serializer("customers.xml");

			for (Customer customer : customers.values()) {
				serializer.addCustomer(customer);
			}

			serializer.save();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	private void loadCustomersFromXML() throws SAXException, IOException,
			ParserConfigurationException {
		Deserializer deserializer = new Deserializer("customers.xml");
		customers = deserializer.getCustomers();
	}

	public int setCustomer(Customer customer) {
		customers.put(customer.getCustomerID(), customer);
		saveCustomersToXML();
		return customers.size();
	}

	public Customer getCustomer(int id) throws SAXException, IOException,
			ParserConfigurationException {
		loadCustomersFromXML();
		Customer customer = customers.get(id);

		if (customer == null)

			customer = new Customer();

		return customer;
	}

	public Object[] getCustomers(float lowerBound, float upperBound)
			throws SAXException, IOException, ParserConfigurationException {
		loadCustomersFromXML();

		ArrayList<Customer> intCustomers = new ArrayList<Customer>();

		for (Customer customer : customers.values()) {
			if (customer.getShoppingAmount() > lowerBound
					&& customer.getShoppingAmount() < upperBound) {
				intCustomers.add(customer);
			}
		}

		return intCustomers.toArray();
	}

}