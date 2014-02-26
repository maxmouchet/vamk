package client;

import handlers.Service;

import java.net.URL;
import java.util.Hashtable;
import java.util.Set;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.util.ClientFactory;

public class Client {

	public static void main(String[] args) {

		try {

			XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();

			// Here we set the server URL

			config.setServerURL(new URL(
					"http://localhost:8080/Assignment33/myxmlrpc"));

			config.setEnabledForExtensions(true);

			config.setEnabledForExceptions(true);

			XmlRpcClient client = new XmlRpcClient();

			client.setConfig(config);

			// In the following we call the methods through dynamic proxy
			
			ClientFactory factory = new ClientFactory(client);
			
			Service service = (Service) factory.newInstance(Service.class);
			
			Hashtable<String, Long> hm = service.getFilesLength();
			Set<String> keys = hm.keySet();
			
	        for(String key: keys){
	            System.out.println(key + " : " + hm.get(key) + " bytes");
	        }
			
		}

		catch (Exception e)

		{

			System.out.println("Exception: " + e.getMessage());

		}

	}

}