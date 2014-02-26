package service.customers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;

public class SOAPCustomersService {

	public OMElement getCustomerInfos(OMElement element)
			throws XMLStreamException {

		element.build();
		element.detach();

		@SuppressWarnings("unchecked")
		Iterator<OMElement> elements = element.getChildElements();

		String hpCustomerId = "";
		String hpCustomerName = "";
		Float hpCustomerPurchase = 0.0f;

		while (elements.hasNext()) {
			OMElement e = elements.next();
			if (e.getLocalName().equals("customer")) {
				@SuppressWarnings("unchecked")
				Iterator<OMElement> customerElements = e.getChildElements();
				String customerId = "";
				String customerName = "";
				Float customerPurchase = 0.0f;

				while (customerElements.hasNext()) {
					OMElement customerElement = customerElements.next();

					if (customerElement.getLocalName().equals("id")) {
						customerId = customerElement.getText();
					} else if (customerElement.getLocalName().equals("name")) {
						customerName = customerElement.getText();
					} else if (customerElement.getLocalName()
							.equals("purchase")) {
						customerPurchase = Float.valueOf(customerElement
								.getText());
					}
				}

				if (customerPurchase > hpCustomerPurchase) {
					hpCustomerId = customerId;
					hpCustomerName = customerName;
					hpCustomerPurchase = customerPurchase;
				}
			}
		}
		
		Customer hpCustomer = new Customer(hpCustomerId, hpCustomerName, hpCustomerPurchase);

		OMFactory omFactory = OMAbstractFactory.getOMFactory();
		OMNamespace omNamespace = omFactory.createOMNamespace(
				"http://service.customers/xsd", "ns");

		OMElement methodElement = omFactory.createOMElement(
				"getCustomerInfosResponse", omNamespace);

		OMElement responseElement = omFactory.createOMElement("customer",
				omNamespace);

		OMElement idElement = omFactory.createOMElement("id", omNamespace);
		idElement.setText(hpCustomer.getId());

		OMElement nameElement = omFactory.createOMElement("name", omNamespace);
		nameElement.setText(hpCustomer.getName());

		OMElement purchaseElement = omFactory.createOMElement("purchase",
				omNamespace);
		purchaseElement.setText(hpCustomer.getPurchase().toString());

		responseElement.addChild(idElement);
		responseElement.addChild(nameElement);
		responseElement.addChild(purchaseElement);

		methodElement.addChild(responseElement);

		return methodElement;
	}

}
