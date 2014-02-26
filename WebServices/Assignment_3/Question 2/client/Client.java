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

			// config.setServerURL(new URL("http://127.0.0.1:8080/xmlrpc"));

			config.setServerURL(new URL("http://127.0.0.1:9500"));

			XmlRpcClient client = new XmlRpcClient();

			client.setConfig(config);

			// In the following we call the methods through dynamic proxy

			ClientFactory factory = new ClientFactory(client);

			ICalculator myCalculator = (ICalculator) factory
					.newInstance(ICalculator.class);

			System.out.println("Prime from 7 to 40");
			Vector<Integer> listPrime = new Vector<Integer>();
			listPrime = myCalculator.getPrimeList(7, 40);
			for(Integer i : listPrime)
				System.out.print(i + " ");
			
			System.out.println("\nString sort: ");
			Vector<String> listString = new Vector<String>();
			Vector<String> listSort = new Vector<String>();
			listString.add("Paul");
			listString.add("Jean");
			listString.add("Zoro");
			listString.add("Tom");
			listString.add("Anna");
			listString.add("Alex");
			listString.add("Charles");
			
			listSort = myCalculator.sortString(listString, "a");
			for(String s : listSort)
				System.out.println(s);
			
		}

		catch (Exception e)

		{

			System.out.println("Exception: " + e.getMessage());

		}

	}

}
