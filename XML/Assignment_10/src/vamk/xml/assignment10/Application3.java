package vamk.xml.assignment10;

import java.io.File;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Application3 {

	public static void main(String[] args) {
		String xmlFile = "collection.xml";
		String xslFile = "collection.xsl";

		try {
			TransformerFactory factory = TransformerFactory.newInstance();

			Source xslt = new StreamSource(new File(xslFile));
			Transformer transformer = factory.newTransformer(xslt);

			Source text = new StreamSource(new File(xmlFile));
			transformer.transform(text, new StreamResult(
					new File("output.html")));

			Runtime runtime = Runtime.getRuntime();
			runtime.exec("open /Applications/Safari.app output.html");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
