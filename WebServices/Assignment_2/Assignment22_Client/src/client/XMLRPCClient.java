package client;

import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;
import org.apache.xmlrpc.client.util.ClientFactory;

import ws.IWebService;

public class XMLRPCClient {

	public static void main(String[] args) {

		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();

		try {

			config.setServerURL(new URL("http://127.0.0.1:"
					+ Integer.parseInt(args[0]) + "/"));
			// config.setServerURL(new URL("http://shell.puv.fi:" +
			// Integer.parseInt(args[0]) + "/"));

			XmlRpcClient client = new XmlRpcClient();

			client.setTransportFactory(new XmlRpcCommonsTransportFactory(client));

			config.setEnabledForExceptions(true);
			client.setConfig(config);

			// Here we create an instance of ClientFactory.
			ClientFactory clientFactory = new ClientFactory(client);

			// Here we apply run-time polymorphism by making an instance
			// of IWebService refer to its implementation class.
			IWebService webService = (IWebService) clientFactory
					.newInstance(IWebService.class);

			Scanner sc = new Scanner(System.in);

			System.out.print("Word: ");
			String word = sc.nextLine().trim();
			
			sc.close();

			Hashtable<String, Integer> hashTable = webService.getWordCount(word);

			System.out.printf("%-10s%5s\n", "File", "Instances of " + word);

			Enumeration<String> enu = hashTable.keys();
			
			String key;
			Integer value;
			
			while (enu.hasMoreElements()) {

				key = enu.nextElement();
				value = hashTable.get(key);

				System.out.printf("%-10s%5s\n", key, value);
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
}