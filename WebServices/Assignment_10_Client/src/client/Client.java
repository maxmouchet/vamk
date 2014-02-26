package client;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

import service.customers.Customer;

public class Client {

	public static void main(String[] args) throws AxisFault {

		EndpointReference targetEPR;

		Options options;
		ServiceClient client;

		OMFactory omFactory;
		OMNamespace omNamespace;

		OMElement methodElement;
		OMElement responseElement;

		Iterator<OMElement> elements;

		/* SOAPPrimesService */
		System.out.println("SOAPPrimesService");

		targetEPR = new EndpointReference(
				"http://app2.cc.puv.fi/mg_axis/services/e1301130_assignment10_primesservice");

		options = new Options();
		options.setTo(targetEPR);

		client = new ServiceClient();
		client.setOptions(options);

		Integer lowerBound = 60;
		Integer upperBound = 100;

		omFactory = OMAbstractFactory.getOMFactory();

		omNamespace = omFactory.createOMNamespace("http://service.primes/xsd",
				"ns");

		methodElement = omFactory.createOMElement("getPrimes", omNamespace);

		OMElement lowerBoundElement = omFactory.createOMElement("lowerBound",
				omNamespace);
		OMElement upperBoundElement = omFactory.createOMElement("upperBound",
				omNamespace);

		lowerBoundElement.setText(lowerBound.toString());
		upperBoundElement.setText(upperBound.toString());

		methodElement.addChild(lowerBoundElement);
		methodElement.addChild(upperBoundElement);

		responseElement = client.sendReceive(methodElement);

		elements = responseElement.getFirstElement().getChildElements();

		while (elements.hasNext()) {
			OMElement e = elements.next();
			System.out.println(e.getText());
		}

		/* SOAPSortService */
		System.out.println("\nSOAPSortService");

		targetEPR = new EndpointReference(
				"http://app2.cc.puv.fi/mg_axis/services/e1301130_assignment10_sortservice");

		options = new Options();
		options.setTo(targetEPR);

		client = new ServiceClient();
		client.setOptions(options);

		Integer[] numbers = { 10, 30, 20 };
		String direction = "ascending";
		// String direction = "descending";

		omFactory = OMAbstractFactory.getOMFactory();

		omNamespace = omFactory.createOMNamespace("http://service.sort/xsd",
				"ns");

		methodElement = omFactory.createOMElement("sort", omNamespace);

		OMElement numbersElement = omFactory.createOMElement("numbers",
				omNamespace);

		for (Integer number : numbers) {
			OMElement numberElement = omFactory.createOMElement("number",
					omNamespace);

			numberElement.addChild(omFactory.createOMText(responseElement,
					number.toString()));

			numbersElement.addChild(numberElement);
		}

		OMElement directionElement = omFactory.createOMElement("direction",
				omNamespace);

		directionElement.setText(direction);

		methodElement.addChild(numbersElement);
		methodElement.addChild(directionElement);

		responseElement = client.sendReceive(methodElement);

		elements = responseElement.getFirstElement().getChildElements();

		while (elements.hasNext()) {
			OMElement e = elements.next();
			System.out.println(e.getText());
		}
		
		/* SOAPCustomersService */
		System.out.println("\nSOAPCustomersService");

		targetEPR = new EndpointReference(
				"http://app2.cc.puv.fi/mg_axis/services/e1301130_assignment10_customersservice");

		options = new Options();
		options.setTo(targetEPR);

		client = new ServiceClient();
		client.setOptions(options);

		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		customers.add(new Customer("c1", "Jack", 100.25f));
		customers.add(new Customer("c2", "Janne", 560.45f));

		omFactory = OMAbstractFactory.getOMFactory();

		omNamespace = omFactory.createOMNamespace("http://service.customers/xsd",
				"ns");

		methodElement = omFactory.createOMElement("getCustomerInfos", omNamespace);

		for (Customer customer : customers) {
			OMElement customerElement = omFactory.createOMElement("customer",
					omNamespace);
			
			OMElement idElement = omFactory.createOMElement("id", omNamespace);
			idElement.setText(customer.getId());

			OMElement nameElement = omFactory.createOMElement("name", omNamespace);
			nameElement.setText(customer.getName());

			OMElement purchaseElement = omFactory.createOMElement("purchase",
					omNamespace);
			purchaseElement.setText(customer.getPurchase().toString());
			
			customerElement.addChild(idElement);
			customerElement.addChild(nameElement);
			customerElement.addChild(purchaseElement);

			methodElement.addChild(customerElement);
		}

		responseElement = client.sendReceive(methodElement);

		elements = responseElement.getFirstElement().getChildElements();

		while (elements.hasNext()) {
			OMElement e = elements.next();
			System.out.println(e.getText());
		}
	}
}