package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;

public class Client {

	public static void main(String[] args) {

		if (args.length < 2) {

			System.out.println("Usage: java Client [server] [port]");
			System.exit(-1);

		}
		double area = 0.0;

		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		try {

			config.setServerURL(new URL("http://" + args[0] + ":"
					+ Integer.parseInt(args[1]) + "/"));

			XmlRpcClient client = new XmlRpcClient();
			client.setTransportFactory(new XmlRpcCommonsTransportFactory(client));

			client.setConfig(config);

			double radius = 0.0;
			double volume = 0.0;
			
			BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in));
			
			System.out.println("Please type ball radius: ");
			try {

				radius = Double.parseDouble(in.readLine());

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}
			
			Object[] params = new Object[] { new Double(radius) };
			volume = (Double) client.execute("action.ballVolume", params);
			
			System.out.println("The ball volume is: " + volume);
			
			System.out.println("Please type circle radius: ");
			try {

				radius = Double.parseDouble(in.readLine());

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

			params = new Object[] { new Double(radius) };

			area = (Double) client.execute("action.circleArea", params);

			System.out.println("The circle area is: " + area);

			System.out.println("Please type rectangle length and width: ");

			double length = 0.0, width = 0.0;

			try {

				System.out.print("Length: ");
				length = Double.parseDouble(in.readLine());

				System.out.print("Width: ");
				width = Double.parseDouble(in.readLine());

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

			params = new Object[] { new Double(length), new Double(width) };

			area = (Double) client.execute("action.rectangleArea", params);

			System.out.println("The rectangle area is: " + area);

			System.out
					.println("Please type triangle edges and the angle between them in degrees: ");

			double edge1 = 0.0, edge2 = 0.0;
			int angle = 0;

			try {
				System.out.print("Edge1: ");
				edge1 = Double.parseDouble(in.readLine());

				System.out.print("Edge2: ");
				edge2 = Double.parseDouble(in.readLine());

				System.out.print("Angle in degrees: ");
				angle = (int) Double.parseDouble(in.readLine());

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

			params = new Object[] { new Double(edge1), new Double(edge2),
					new Integer(angle) };

			area = (Double) client.execute("action.triangleArea", params);

			System.out.println("The triangle area is: " + area);

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
}