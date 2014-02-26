package ws.customer.service;

import java.io.IOException;
import java.util.Hashtable;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ws.customer.data.Customer;

public class Deserializer {

	private Document document;

	public Deserializer(String filename) throws SAXException, IOException,
			ParserConfigurationException {
		document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(filename);
		document.getDocumentElement().normalize();
	}

	public Hashtable<Integer, Customer> getCustomers() {
		Hashtable<Integer, Customer> customers = new Hashtable<Integer, Customer>();

		NodeList nodeList = document.getElementsByTagName("customer");

		for (int i = 0; i < nodeList.getLength(); i++) {
			if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
				Customer customer = new Customer();

				Element element = (Element) nodeList.item(i);
				NamedNodeMap attList = element.getAttributes();

				for (int j = 0; j < attList.getLength(); j++) {
					if (attList.item(j).getNodeName().equals("id")) {
						customer.setCustomerID(Integer.parseInt(attList.item(j)
								.getNodeValue()));
					}
				}

				NodeList elementList = element.getElementsByTagName("*");

				for (int k = 0; k < elementList.getLength(); k++) {
					if (elementList.item(k).getNodeName().equals("name")) {
						customer.setCustomerName(elementList.item(k)
								.getTextContent());
					} else if (elementList.item(k).getNodeName()
							.equals("shoppingAmount")) {
						customer.setShoppingAmount(Float.parseFloat(elementList
								.item(k).getTextContent()));
					} else if (elementList.item(k).getNodeName()
							.equals("privileged")) {
						customer.setPrivileged(Boolean.parseBoolean(elementList
								.item(k).getTextContent()));
					} else if (elementList.item(k).getNodeName()
							.equals("discountPercentage")) {
						customer.setDiscountPercentage(Integer
								.parseInt(elementList.item(k).getTextContent()));
					}
				}
				
				customers.put(customer.getCustomerID(), customer);
			}

		}
		return customers;
	}

}