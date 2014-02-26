package client;

import handlers.AuthService;
import handlers.IOService;

import java.net.URL;
import java.util.Locale;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.util.ClientFactory;

public class Client {

	public static void main(String[] args) {

		try {

			XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();

			// Change this at VAMK
			String baseUrl = "http://127.0.0.1:8080/Example52_Server";

			config.setServerURL(new URL(baseUrl + "/auth"));

			config.setEnabledForExtensions(true);

			config.setEnabledForExceptions(true);

			// Change this at VAMK
			config.setBasicUserName("max");
			config.setBasicPassword("max");

			XmlRpcClient client = new XmlRpcClient();

			client.setConfig(config);

			ClientFactory factory = new ClientFactory(client);

			AuthService authService = (AuthService) factory
					.newInstance(AuthService.class);

			String serviceUrl = authService.getServiceUrl();

			config.setServerURL(new URL(baseUrl + serviceUrl));

			config.setBasicUserName("Peter");
			config.setBasicPassword("2000");

			IOService ioService = (IOService) factory
					.newInstance(IOService.class);

			Object[] files = (Object[]) ioService.listFiles();

			for (Object string : files) {
				System.out.println((String) string);
			}

		}

		catch (Exception e)

		{

			System.out.println("Exception: " + e.getMessage());

		}

	}
}