package client;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import ws.customer.data.Customer;

public class CustomerRPCClient {

	public static void main(String[] args1) throws AxisFault {

		RPCServiceClient serviceClient = new RPCServiceClient();

		Options options = serviceClient.getOptions();

		EndpointReference targetEPR = new EndpointReference(
				"http://localhost:8080/axis2/services/CustomerService");

		// EndpointReference targetEPR = new EndpointReference(
		// "http://app.cc.puv.fi/axis2/services/mg_CustomerService2");

		options.setTo(targetEPR);

		int[] ids = { 4000, 5000, 6000 };
		String[] names = { "Rao", "Sakari", "Laura" };
		float[] shoppinGAmounts = { 123.54f, 320.40f, 58.89f };
		boolean[] priviliged = { true, true, false };
		int[] discountPercentages = { 3, 10, 2 };

		// Setting the customer information

		QName opSetCustomer = new QName("http://service.customer.ws",
				"setCustomer");

		Customer customer = null;
		Object[] opSetCustomerArgs = null;

		for (int i = 0; i < ids.length; i++) {
			customer = new Customer();
			customer.setCustomerName(names[i]);
			customer.setCustomerID(ids[i]);
			customer.setShoppingAmount(shoppinGAmounts[i]);
			customer.setPrivileged(priviliged[i]);
			customer.setDiscountPercentage(discountPercentages[i]);

			opSetCustomerArgs = new Object[] { customer };

			serviceClient.invokeRobust(opSetCustomer, opSetCustomerArgs);
		}

		// Here we get the customer information based on a LOWER and an UPPER
		// bound.

		QName opGetCustomers = new QName("http://service.customer.ws",
				"getCustomers");

		float lowerBound = 100.00f;
		float upperBound = 200.00f;

		Object[] opGetCustomersArgs = new Object[] { lowerBound, upperBound };

		Class[] returnTypes = new Class[] { Customer[].class };

		Object[] response = serviceClient.invokeBlocking(opGetCustomers,

		opGetCustomersArgs, returnTypes);

		Customer[] results = (Customer[]) response[0];

		System.out.println("Customers whose shopping amount is between "
				+ lowerBound + " and " + upperBound);

		for (int i = 0; i < results.length; i++) {
			System.out.println(results[i].getCustomerName() + " "
					+ results[i].getShoppingAmount());
		}

		System.out.println("\nNow we get a customer with his id");

		// Here we get the customer information

		int id = ids[0];
		QName opGetCustomer = new QName("http://service.customer.ws",
				"getCustomer");

		Object[] opGetCustomerArgs = new Object[] { id };

		returnTypes = new Class[] { Customer.class };

		response = serviceClient.invokeBlocking(opGetCustomer,

		opGetCustomerArgs, returnTypes);

		Customer result = (Customer) response[0];

		// Displaying the result

		System.out.println("Customer name : " +

		result.getCustomerName());

		System.out.println("Customer ID : " +

		result.getCustomerID());

		System.out.println("Shopping amount : " +

		result.getShoppingAmount());

		System.out.println("Customer is privileged? : " +

		result.getPrivileged());

		System.out.println("Discount amount : " +

		result.getDiscount());

	}

}