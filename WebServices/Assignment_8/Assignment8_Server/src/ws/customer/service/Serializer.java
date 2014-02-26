package ws.customer.service;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import ws.customer.data.Customer;

public class Serializer {

	private Document xmlDoc;
	private Element root;

	public Serializer(String filename) throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();

		xmlDoc = documentBuilder.newDocument();

		root = xmlDoc.createElement("customers");
		xmlDoc.appendChild(root);
	}

	public void addCustomer(Customer customer) {
		Element customerElement = xmlDoc.createElement("customer");

		customerElement.setAttribute("id", customer.getCustomerID().toString());

		Element nameElement = xmlDoc.createElement("name");
		Text nameText = xmlDoc.createTextNode(customer.getCustomerName());
		nameElement.appendChild(nameText);

		Element amountElement = xmlDoc.createElement("shoppingAmount");
		Text amountText = xmlDoc.createTextNode(Float.toString(customer
				.getShoppingAmount()));
		amountElement.appendChild(amountText);

		Element privilegedElement = xmlDoc.createElement("privileged");
		Text privilegedText = xmlDoc.createTextNode(Boolean.toString(customer
				.getPrivileged()));
		privilegedElement.appendChild(privilegedText);

		Element discountElement = xmlDoc.createElement("discountPercentage");
		Text discountText = xmlDoc.createTextNode(Integer.toString(customer
				.getDiscountPercentage()));
		discountElement.appendChild(discountText);

		customerElement.appendChild(nameElement);
		customerElement.appendChild(amountElement);
		customerElement.appendChild(privilegedElement);
		customerElement.appendChild(discountElement);

		root.appendChild(customerElement);
	}

	public void save() throws TransformerException {
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = transformerFactory.newTransformer();

		Source src = new DOMSource(xmlDoc);
		Result output = new StreamResult(new File("customers.xml"));

		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

		transformer.transform(src, output);
	}

}