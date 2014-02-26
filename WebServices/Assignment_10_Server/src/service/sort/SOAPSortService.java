package service.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;

public class SOAPSortService {

	public OMElement sort(OMElement element) throws XMLStreamException {

		element.build();
		element.detach();

		@SuppressWarnings("unchecked")
		Iterator<OMElement> elements = element.getChildElements();

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		String direction = "";

		while (elements.hasNext()) {
			OMElement e = elements.next();
			if (e.getLocalName().equals("numbers")) {
				@SuppressWarnings("unchecked")
				Iterator<OMElement> numberElements = e.getChildElements();

				while (numberElements.hasNext()) {
					numbers.add(Integer
							.valueOf(numberElements.next().getText()));
				}
			} else if (e.getLocalName().equals("direction")) {
				direction = e.getText();
			}
		}

		if (direction.equals("ascending")) {
			Collections.sort(numbers);
		} else if (direction.equals("descending")) {
			Collections.sort(numbers);
			Collections.reverse(numbers);
		}

		OMFactory omFactory = OMAbstractFactory.getOMFactory();
		OMNamespace omNamespace = omFactory.createOMNamespace(
				"http://service.sort/xsd", "ns");

		OMElement methodElement = omFactory.createOMElement("sortResponse",
				omNamespace);

		OMElement responseElement = omFactory.createOMElement("numbers",
				omNamespace);

		for (Integer number : numbers) {
			OMElement numberElement = omFactory.createOMElement("number",
					omNamespace);

			numberElement.addChild(omFactory.createOMText(responseElement,
					number.toString()));

			responseElement.addChild(numberElement);
		}

		methodElement.addChild(responseElement);

		return methodElement;
	}
}
