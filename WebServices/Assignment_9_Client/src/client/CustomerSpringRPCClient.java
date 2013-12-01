package client;

import javax.xml.namespace.QName;

import org.apache.axiom.om.impl.llom.OMTextImpl;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ws.customer.data.Customer;

public class CustomerSpringRPCClient {

	private static void init() {
		Logger log = Logger.getLogger(CustomerSpringRPCClient.class);
		log.setLevel(Level.DEBUG);
		log.debug("Debug message");
		log.info("INFO message");
		log.warn("Warning message");
		log.error("Error message");
		log.fatal("Fatal");
	}

	public static void main(String[] args1) throws AxisFault {

		init();
		RPCServiceClient serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();
		EndpointReference targetEPR = new EndpointReference(
				"http://app2.cc.puv.fi/mg_axis/services/mm_CustomerSpringService_In");

		options.setTo(targetEPR);

		QName opGetCustomer = new QName("http://service.customer.ws",
				"getCustomerByID");
		QName opGetCustomerIds = new QName("http://service.customer.ws",
				"getCustomerIds");
		QName opGetCustomerWithLargestAmount = new QName(
				"http://service.customer.ws", "getCustomerWithLargestAmount");
		QName opGetCustomersByType = new QName("http://service.customer.ws",
				"getCustomersByType");

		Object[] opGetCustomerArgs = new Object[] { 3000 };
		Object[] opGetCustomersByTypeArgs = new Object[] { false };

		Class[] returnTypes;
		Object[] response;

		// opGetCustomer
		System.out.println("\nopGetCustomer");

		returnTypes = new Class[] { Customer.class };
		response = serviceClient.invokeBlocking(opGetCustomer,
				opGetCustomerArgs, returnTypes);

		Customer opGetCustomerResult = (Customer) response[0];

		try {
			System.out.println("Customer name : "
					+ opGetCustomerResult.getCustomerName());
			System.out.println("Customer ID : "
					+ opGetCustomerResult.getCustomerID());
			System.out.println("Shopping amount : "
					+ opGetCustomerResult.getShoppingAmount());
			System.out.println("Customer is privileged? : "
					+ opGetCustomerResult.getPrivileged());
			System.out.println("Discount amount : "
					+ opGetCustomerResult.getDiscount());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// opGetCustomerWithLargestAmount
		System.out.println("\nopGetCustomerWithLargestAmount");

		returnTypes = new Class[] { Customer.class };
		response = serviceClient.invokeBlocking(opGetCustomerWithLargestAmount,
				new Object[] {}, returnTypes);

		Customer opGetCustomerWithLargestAmountResult = (Customer) response[0];

		try {
			System.out.println("Customer name : "
					+ opGetCustomerWithLargestAmountResult.getCustomerName());
			System.out.println("Customer ID : "
					+ opGetCustomerWithLargestAmountResult.getCustomerID());
			System.out.println("Shopping amount : "
					+ opGetCustomerWithLargestAmountResult.getShoppingAmount());
			System.out.println("Customer is privileged? : "
					+ opGetCustomerWithLargestAmountResult.getPrivileged());
			System.out.println("Discount amount : "
					+ opGetCustomerWithLargestAmountResult.getDiscount());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// opGetCustomerIds
		System.out.println("\nopGetCustomerIds");

		returnTypes = new Class[] { Object[].class };
		response = serviceClient.invokeBlocking(opGetCustomerIds,
				new Object[] {}, returnTypes);

		Object[] opGetCustomerIdsResult = (Object[]) response[0];

		try {
			for (Object id : opGetCustomerIdsResult) {
				System.out.println(((OMTextImpl) id).getText());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// opGetCustomersByType
		System.out.println("\nopGetCustomersByType");

		returnTypes = new Class[] { Object[].class };
		response = serviceClient.invokeBlocking(opGetCustomersByType,
				opGetCustomersByTypeArgs, returnTypes);

		Object[] opGetCustomersByTypeResult = (Object[]) response[0];

		try {
			for (Object id : opGetCustomersByTypeResult) {
				System.out.println(((OMTextImpl) id).getText());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}