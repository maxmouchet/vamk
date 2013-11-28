package vamk.xml.assignment10;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class Application2 {

	public static void main(String[] args) {
		String xmlFile = "collection.xml";
		String xsdFile = "collection.xsd";

		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
					.newInstance();

			documentBuilderFactory.setValidating(false);
			documentBuilderFactory.setNamespaceAware(true);

			SchemaFactory schemaFactory = SchemaFactory
					.newInstance("http://www.w3.org/2001/XMLSchema");

			documentBuilderFactory.setSchema(schemaFactory
					.newSchema(new StreamSource(xsdFile)));

			DocumentBuilder documentBuilder = documentBuilderFactory
					.newDocumentBuilder();

			documentBuilder.setErrorHandler(new org.xml.sax.ErrorHandler() {
				public void fatalError(SAXParseException exception)
						throws SAXException {
					System.out.println("Fatal error at line: ["
							+ exception.getLineNumber() + ":"
							+ exception.getColumnNumber() + "]" + "\n"
							+ exception.getMessage());
					System.exit(1);
				}

				public void error(SAXParseException exception)
						throws SAXParseException {
					System.out.println("Error at line: ["
							+ exception.getLineNumber() + ":"
							+ exception.getColumnNumber() + "]" + "\n"
							+ exception.getMessage());
					System.exit(1);
				}

				public void warning(SAXParseException exception)
						throws SAXParseException {

					System.out.println("Warning at line: ["
							+ exception.getLineNumber() + ":"
							+ exception.getColumnNumber() + "]" + "\n"
							+ exception.getMessage());
				}
			});

			Document document = documentBuilder.parse(xmlFile);
			DOMSource source = new DOMSource(document);

			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			StreamResult streamResult = new StreamResult(System.out);
			transformer.transform(source, streamResult);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
