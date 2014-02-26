package client;

import handlers.IActionHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;
import org.apache.xmlrpc.client.util.ClientFactory;

public class Client {

	public static void main(String[] args) {

		if (args.length < 2) {
			System.out.println("Usage: java Client [server] [port]");
			System.exit(-1);
		}

		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		try {

			config.setServerURL(new URL("http://" + args[0] + ":"
					+ Integer.parseInt(args[1]) + "/"));		
			

			XmlRpcClient client = new XmlRpcClient();
			client.setTransportFactory(new XmlRpcCommonsTransportFactory(client));
			client.setConfig(config);

			ClientFactory factory = new ClientFactory(client);
			IActionHandler actionHandler = (IActionHandler) factory.newInstance(IActionHandler.class);
			
			// For reading user input
			Scanner sc = new Scanner(System.in);
			String cmd = "";

			while (cmd != "exit") {

				System.out.print("$ ");
				cmd = sc.nextLine().trim();

				// cmdArgs is an array containing the command
				// entered by the user and his arguments.
				String[] cmdArgs = cmd.split("\\s+");

				switch (cmdArgs[0]) {

				case "ls":
					ls(actionHandler, cmdArgs);
					break;

				case "show":
					show(actionHandler, cmdArgs);
					break;

				case "write":
					write(actionHandler, cmdArgs);
					break;

				case "append":
					append(actionHandler, cmdArgs);
					break;

				case "help":
					System.out.println("Available commands:");
					System.out.println("ls [FILE] - list directory contents");
					System.out.println("show FILE - show file contents");
					System.out
							.println("write FILE TEXT - create/replace file with text");
					System.out
							.println("append FILE TEXT - append text to file");
					break;

				default:
					System.out.println("Command not found: " + cmdArgs[0]);
					break;
				}

			}

			sc.close();

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

	private static void ls(IActionHandler actionHandler, String[] cmdArgs)
			throws XmlRpcException {
		String path = "";

		switch (cmdArgs.length) {
		case 1:
			path = ".";
			break;

		case 2:
			path = cmdArgs[1];
			break;

		default:
			System.out.println("Usage: ls [FILE]");
			break;
		}

		if (path != "") {
			Object[] files = actionHandler.listFiles(path);

			for (Object file : files) {
				System.out.println((String) file);
			}
		}
	}

	private static void show(IActionHandler actionHandler, String[] cmdArgs)
			throws XmlRpcException {

		if (cmdArgs.length == 2) {
			String content = "";
			
			try {
				content = actionHandler.readFile(cmdArgs[1]);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			System.out.println(content);
		} else {
			System.out.println("Usage: show FILE");
		}
	}

	private static void write(IActionHandler actionHandler, String[] cmdArgs)
			throws XmlRpcException {
		String text = "";
		
		// Rejoin the text
		for (int i = 2; i < cmdArgs.length; i++) {
			text += cmdArgs[i] + " ";
		}

		if (cmdArgs.length >= 3) {
			try {
				actionHandler.writeFile(cmdArgs[1], text.trim(), false);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Usage: write FILE TEXT");
		}
	}

	private static void append(IActionHandler actionHandler, String[] cmdArgs)
			throws XmlRpcException {
		String text = "";
		
		// Rejoin the text
		for (int i = 2; i < cmdArgs.length; i++) {
			text += cmdArgs[i] + " ";
		}

		if (cmdArgs.length >= 3) {
			try {
				actionHandler.writeFile(cmdArgs[1], text.trim(), true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Usage: append FILE TEXT");
		}
	}

}