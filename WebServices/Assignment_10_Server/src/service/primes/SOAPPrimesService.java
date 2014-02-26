package service.primes;

import java.util.Iterator;
import java.util.Vector;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;

public class SOAPPrimesService {

	public OMElement getPrimes(OMElement element) throws XMLStreamException {

		element.build();
		element.detach();

		@SuppressWarnings("unchecked")
		Iterator<OMElement> elements = element.getChildElements();

		Integer lowerBound = 0;
		Integer upperBound = 0;

		while (elements.hasNext()) {
			OMElement e = elements.next();
			if (e.getLocalName().equals("lowerBound")) {
				lowerBound = Integer.valueOf(e.getText());
			} else if (e.getLocalName().equals("upperBound")) {
				upperBound = Integer.valueOf(e.getText());
			}
		}

		Vector<Integer> primes = getPrimeList(lowerBound, upperBound);

		OMFactory omFactory = OMAbstractFactory.getOMFactory();
		OMNamespace omNamespace = omFactory.createOMNamespace(
				"http://service.primes/xsd", "ns");

		OMElement methodElement = omFactory.createOMElement("primesResponse",
				omNamespace);

		OMElement responseElement = omFactory.createOMElement("primes",
				omNamespace);

		for (Integer prime : primes) {
			OMElement primeElement = omFactory.createOMElement("prime",
					omNamespace);

			primeElement.addChild(omFactory.createOMText(responseElement,
					prime.toString()));

			responseElement.addChild(primeElement);
		}

		methodElement.addChild(responseElement);

		return methodElement;
	}

	private Vector<Integer> getPrimeList(int lower, int upper) {
		Vector<Integer> primeList = new Vector<Integer>();
		for (int i = lower; i < upper; i++)
			if (isPrime(i))
				primeList.add(i);
		return primeList;
	}

	private static boolean isPrime(int number) {
		for (int i = 2; i < number; i++) {
			if (number % i == 0)
				return false;
		}
		return (number > 1);
	}

}
