package vamk.xml.assignment10;

import java.io.FileOutputStream;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Application1 {

	public static void main(String[] args) {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();

		DocumentBuilder documentBuilder = null;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		Document document = documentBuilder.newDocument();

		Element root = document.createElement("collection");
		document.appendChild(root);

		Element cdsElement = document.createElement("cds");
		root.appendChild(cdsElement);

		cdsElement.appendChild(createCdElement(document, "Imagine",
				"John Lennon", "C2000", 10.90, 1978));

		cdsElement.appendChild(createCdElement(document, "Bye Bye Baby",
				"Terry Nice", "C1000", 12.90, 2010));

		cdsElement.appendChild(createCdElement(document, "Be Happy",
				"Jerry Adams", "C3000", 30.90, 2006));

		Element companiesElement = document.createElement("companies");
		root.appendChild(companiesElement);

		companiesElement.appendChild(createCompanyElement(document, "C1000",
				"Folk Music Company"));
		companiesElement.appendChild(createCompanyElement(document, "C2000",
				"Oriental Songs"));
		companiesElement.appendChild(createCompanyElement(document, "C3000",
				"Entertainment Company"));

		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		try {
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

			Source source = new DOMSource(document);
			Result output = new StreamResult(new FileOutputStream(
					"collection.xml"));

			transformer.transform(source, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Element createCdElement(Document document, String title,
			String artist, String companyId, double price, int year) {
		Element cd = document.createElement("cd");

		Element cdTitleElement = document.createElement("title");
		Text cdTitleText = document.createTextNode(title);
		cdTitleElement.appendChild(cdTitleText);

		Element cdArtistElement = document.createElement("artist");
		Text cdArtistText = document.createTextNode(artist);
		cdArtistElement.appendChild(cdArtistText);

		Element cdCompanyIdElement = document.createElement("company_id");
		Text cdCompanyIdText = document.createTextNode(companyId);
		cdCompanyIdElement.appendChild(cdCompanyIdText);

		Element cdPriceElement = document.createElement("price");
		Text cdPriceText = document.createTextNode(String.valueOf(price));
		cdPriceElement.appendChild(cdPriceText);

		Element cdYearElement = document.createElement("year");
		Text cdYearText = document.createTextNode(String.valueOf(year));
		cdYearElement.appendChild(cdYearText);

		cd.appendChild(cdTitleElement);
		cd.appendChild(cdArtistElement);
		cd.appendChild(cdCompanyIdElement);
		cd.appendChild(cdPriceElement);
		cd.appendChild(cdYearElement);

		return cd;
	}

	private static Element createCompanyElement(Document document, String id,
			String name) {
		Element company = document.createElement("company");

		Element companyIdElement = document.createElement("id");
		Text companyIdText = document.createTextNode(id);
		companyIdElement.appendChild(companyIdText);

		Element companyNameElement = document.createElement("name");
		Text companyNameText = document.createTextNode(name);
		companyNameElement.appendChild(companyNameText);

		company.appendChild(companyIdElement);
		company.appendChild(companyNameElement);

		return company;
	}

}
