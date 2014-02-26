//This is client.Client.java file

package client;

import java.net.URL;
import java.util.Vector;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.util.ClientFactory;

import ws.ICalculator;

public class Client {

	public static void main(String[] args) {

		try {

			XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();

			config.setServerURL(new URL("http://127.0.0.1:9500"));

			XmlRpcClient client = new XmlRpcClient();

			client.setConfig(config);

			// In the following we call the methods through dynamic proxy

			ClientFactory factory = new ClientFactory(client);

			ICalculator myCalculator = (ICalculator) factory
					.newInstance(ICalculator.class);

			System.out.println("The numbers returned by the service: ");
			Vector<Double> numbers1 = myCalculator.getNumbers(10);
			Vector<Double> numbers2 = myCalculator.getNumbers(10);
			for (Double d : numbers1)
				System.out.print(d + " ");
			System.out.println("\nAnd: ");
			for (Double d : numbers2)
				System.out.print(d + " ");

			System.out
					.println("\n\nThe mutated numbers returned by the service: ");
			Vector<Double> listVector = myCalculator.swapRand(numbers1,
					numbers2);
			for (Double d : listVector) {
				if (d == -1.0)
					System.out.println("\nAnd:");
				else
					System.out.print(d + " ");
			}
		} catch (Exception e)

		{

			System.out.println("Exception: " + e.getMessage());

		}

	}

}