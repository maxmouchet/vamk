package server;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.apache.xmlrpc.XmlRpcException;

import org.apache.xmlrpc.server.PropertyHandlerMapping;

import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;

import org.apache.xmlrpc.webserver.XmlRpcServletServer;

public class XmlRpcServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private XmlRpcServletServer server = null;

	private XmlRpcServerConfigImpl serverConfig;

	private PropertyHandlerMapping mapping = null;

	public void init() {

		try {

			server = new XmlRpcServletServer();

			mapping = new PropertyHandlerMapping();

			// Here we define handlers for the server.

			mapping.addHandler("service", handlers.ServiceImpl.class);

			mapping.addHandler("handlers.Service",
					handlers.ServiceImpl.class);

			server.setHandlerMapping(mapping);

			serverConfig = (XmlRpcServerConfigImpl) server.getConfig();

			serverConfig.setEnabledForExceptions(true);

			serverConfig.setEnabledForExtensions(true);

			server.setConfig(serverConfig);

		} catch (XmlRpcException e) {

			e.getMessage();

		}

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Here we call the XmlRpcServletServer to execute the request.

		server.execute(request, response);

	}

}