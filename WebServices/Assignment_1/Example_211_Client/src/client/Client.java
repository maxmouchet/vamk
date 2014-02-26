package client;

import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;

public class Client {

	public static void main(String[] args) {

		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();

		try {

			config.setServerURL(new URL("http://127.0.0.1:"
					+ Integer.parseInt(args[0]) + "/"));

			XmlRpcClient client = new XmlRpcClient();

			client.setTransportFactory(new XmlRpcCommonsTransportFactory(client));

			client.setConfig(config);

			Object[] params = new Object[] { new String("Amanda") };
			String msg = (String) client.execute(
					"handlers.ActionHandler.getDate", params);
			System.out.println(msg);
			
			Scanner sc = new Scanner(System.in);
			
			Vector<Integer> values = new Vector<Integer>();
			
			for (int i = 0; i < 5; i++) {
				System.out.print("Please enter number " + i + ": ");
				values.add(sc.nextInt());
			}
			
			params = new Object[] { new Vector<Integer>(values) };
			msg = (String) client.execute(
					"handlers.ActionHandler.getMinValue", params).toString();
			System.out.println(msg);

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
}