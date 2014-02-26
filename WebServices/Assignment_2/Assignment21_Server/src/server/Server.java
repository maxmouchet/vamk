package server;

import java.io.File;
import java.io.IOException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

public class Server {

	public static void main(String[] args) {

		if (args.length < 1) {

			System.out.println("Usage: java Server [port]");
			System.exit(-1);

		}

		System.out.println("Attempting to start XML-RPC server...");

		// Here we define myHandler.properties property file,which is located
		// under resources directory.
		final String propertyFile = "resources/myHandler.properties".replace(
				File.separatorChar, '/');

		try {
			WebServer webServer = new WebServer(Integer.parseInt(args[0]));
			
			XmlRpcServer server = webServer.getXmlRpcServer();
			
			PropertyHandlerMapping phm = new PropertyHandlerMapping();
			// A class loader is an object that is responsible for loading
			// classes.
			// Given the name of a class, a class loader should attempt to
			// locate or generate data that constitutes a definition for the
			// class.
			// Here we register the services for dynamic proxy.
			phm.addHandler(handlers.IActionHandler.class.getName(), handlers.ActionHandler.class);

			// Here we append the handler mapping to the server
			server.setHandlerMapping(phm);
			
			XmlRpcServerConfigImpl config = new XmlRpcServerConfigImpl();	

			server.setConfig(config);
			server.setHandlerMapping(phm);

			webServer.start();

			System.out.println("Server is successfully started at port "
					+ args[0]);

		} catch (XmlRpcException e) {

			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}

	}

}