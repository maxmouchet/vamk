package vamk.xml.assignment11;

import java.io.IOException;
import java.util.Hashtable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Application {

	private static Document document;
	private final static String xmlFile = "collection.xml";

	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();

		documentBuilderFactory.setValidating(false);
		documentBuilderFactory.setNamespaceAware(true);

		DocumentBuilder documentBuilder = documentBuilderFactory
				.newDocumentBuilder();

		document = documentBuilder.parse(xmlFile);

		System.out.println("getCdsTitleWithCompanyName()\n---");
		Hashtable<String, String> cdsTitleWithCompanyName = getCdsTitleWithCompanyName();
		for (String key : cdsTitleWithCompanyName.keySet()) {
			System.out.println("Title: " + key + " / Company: "
					+ cdsTitleWithCompanyName.get(key));
		}

		System.out.println("\ngetAveragePrice()\n---");
		System.out.println(getAveragePrice());

		System.out.println("\ngetExtremePriceCds()\n---");
		Hashtable<String, String> extremePriceCds = getExtremePriceCds();
		System.out.println("leastExpensiveTitle: "
				+ extremePriceCds.get("leastExpensiveTitle"));
		System.out.println("mostExpensiveTitle: "
				+ extremePriceCds.get("mostExpensiveTitle"));

		System.out.println("\ngetOldestNewestCds()\n---");
		Hashtable<String, String> oldestNewestCds = getOldestNewestCds();
		System.out
				.println("oldestTitle: " + oldestNewestCds.get("oldestTitle"));
		System.out
				.println("newestTitle: " + oldestNewestCds.get("newestTitle"));
	}

	private static String getCompanyName(String companyId) {
		String companyName = "";

		NodeList companies = document.getElementsByTagName("company");
		Boolean companyFound = false;

		for (int i = 0; i < companies.getLength() && !companyFound; i++) {
			Node company = companies.item(i);

			NodeList nodes = company.getChildNodes();
			for (int j = 0; j < nodes.getLength(); j++) {
				Node node = nodes.item(j);
				if (node.getNodeName().equals("id")
						&& node.getFirstChild().getNodeValue()
								.equals(companyId)) {
					companyFound = true;
				} else if (node.getNodeName().equals("name") && companyFound) {
					companyName = node.getFirstChild().getNodeValue();
				}
			}
		}

		return companyName;
	}

	private static Hashtable<String, String> getCdsTitleWithCompanyName() {
		Hashtable<String, String> result = new Hashtable<String, String>();

		NodeList cds = document.getElementsByTagName("cd");
		for (int i = 0; i < cds.getLength(); i++) {
			String title = "";
			String company = "";

			NodeList nodes = cds.item(i).getChildNodes();
			for (int j = 0; j < nodes.getLength(); j++) {
				Node node = nodes.item(j);
				if (node.getNodeName().equals("title")) {
					title = node.getFirstChild().getNodeValue();
				} else if (node.getNodeName().equals("company_id")) {
					company = getCompanyName(node.getFirstChild()
							.getNodeValue());
				}
			}
			result.put(title, company);
		}
		return result;
	}

	private static float getAveragePrice() {
		Float totalPrice = 0.0f;
		Integer count = 0;

		NodeList cds = document.getElementsByTagName("cd");
		for (int i = 0; i < cds.getLength(); i++) {
			NodeList nodes = cds.item(i).getChildNodes();
			Boolean priceFound = false;

			for (int j = 0; j < nodes.getLength() && !priceFound; j++) {
				Node node = nodes.item(j);
				if (node.getNodeName().equals("price")) {
					totalPrice += Float.valueOf(node.getFirstChild()
							.getNodeValue());
					count++;
					priceFound = true;
				}
			}
		}

		return totalPrice / count;
	}

	private static Hashtable<String, String> getExtremePriceCds() {
		Hashtable<String, String> result = new Hashtable<String, String>();
		result.put("leastExpensiveTitle", "");
		result.put("mostExpensiveTitle", "");

		Float lowestPrice = null;
		Float highestPrice = 0.0f;

		NodeList cds = document.getElementsByTagName("cd");
		for (int i = 0; i < cds.getLength(); i++) {
			NodeList nodes = cds.item(i).getChildNodes();

			String title = "";
			Boolean isLeastExpensive = false;
			Boolean isMostExpensive = false;

			for (int j = 0; j < nodes.getLength(); j++) {
				Node node = nodes.item(j);

				if (node.getNodeName().equals("title")) {
					title = node.getFirstChild().getNodeValue();
				} else if (node.getNodeName().equals("price")) {
					Float price = Float.valueOf(node.getFirstChild()
							.getNodeValue());
					if (lowestPrice == null) {
						lowestPrice = price;
					}
					if (price <= lowestPrice) {
						lowestPrice = price;
						isLeastExpensive = true;
					}
					if (price >= highestPrice) {
						highestPrice = price;
						isMostExpensive = true;
					}
				}
			}

			if (isLeastExpensive) {
				result.put("leastExpensiveTitle", title);
			}
			if (isMostExpensive) {
				result.put("mostExpensiveTitle", title);
			}
		}

		return result;
	}

	private static Hashtable<String, String> getOldestNewestCds() {
		Hashtable<String, String> result = new Hashtable<String, String>();
		result.put("oldestTitle", "");
		result.put("newestTitle", "");

		Integer lowestYear = null;
		Integer highestYear = 0;

		NodeList cds = document.getElementsByTagName("cd");
		for (int i = 0; i < cds.getLength(); i++) {
			NodeList nodes = cds.item(i).getChildNodes();

			String title = "";
			Boolean isOldest = false;
			Boolean isNewest = false;

			for (int j = 0; j < nodes.getLength(); j++) {
				Node node = nodes.item(j);

				if (node.getNodeName().equals("title")) {
					title = node.getFirstChild().getNodeValue();
				} else if (node.getNodeName().equals("year")) {
					Integer year = Integer.valueOf(node.getFirstChild()
							.getNodeValue());
					if (lowestYear == null) {
						lowestYear = year;
					}
					if (year <= lowestYear) {
						lowestYear = year;
						isOldest = true;
					}
					if (year >= highestYear) {
						highestYear = year;
						isNewest = true;
					}
				}
			}

			if (isOldest) {
				result.put("oldestTitle", title);
			}
			if (isNewest) {
				result.put("newestTitle", title);
			}
		}

		return result;
	}

}
