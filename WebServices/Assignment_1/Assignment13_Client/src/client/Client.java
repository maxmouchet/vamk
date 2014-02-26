package client;

import java.net.URL;
import java.util.Scanner;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;

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
					ls(client, cmdArgs);
					break;

				case "show":
					show(client, cmdArgs);
					break;

				case "write":
					write(client, cmdArgs);
					break;

				case "append":
					append(client, cmdArgs);
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

	private static void ls(XmlRpcClient client, String[] cmdArgs)
			throws XmlRpcException {
		Object[] params = null;

		switch (cmdArgs.length) {
		case 1:
			params = new Object[] { new String(".") };
			break;

		case 2:
			params = new Object[] { new String(cmdArgs[1]) };
			break;

		default:
			System.out.println("Usage: ls [FILE]");
			break;
		}

		if (params != null) {
			Object[] files = (Object[]) client.execute("action.listFiles",
					params);

			for (Object file : files) {
				System.out.println((String) file);
			}
		}
	}

	private static void show(XmlRpcClient client, String[] cmdArgs)
			throws XmlRpcException {
		Object[] params = null;

		if (cmdArgs.length == 2) {
			params = new Object[] { new String(cmdArgs[1]) };
			String content = (String) client.execute("action.readFile", params);

			System.out.println(content);
		} else {
			System.out.println("Usage: show FILE");
		}
	}

	private static void write(XmlRpcClient client, String[] cmdArgs)
			throws XmlRpcException {
		Object[] params = null;
		String text = "";
		
		// Rejoin the text
		for (int i = 2; i < cmdArgs.length; i++) {
			text += cmdArgs[i] + " ";
		}

		if (cmdArgs.length >= 3) {
			params = new Object[] { cmdArgs[1], text.trim(), false };
			client.execute("action.writeFile", params);
		} else {
			System.out.println("Usage: write FILE TEXT");
		}
	}

	private static void append(XmlRpcClient client, String[] cmdArgs)
			throws XmlRpcException {
		Object[] params = null;
		String text = "";
		
		// Rejoin the text
		for (int i = 2; i < cmdArgs.length; i++) {
			text += cmdArgs[i] + " ";
		}

		if (cmdArgs.length >= 3) {
			params = new Object[] { cmdArgs[1], text.trim(), true };
			client.execute("action.writeFile", params);
		} else {
			System.out.println("Usage: append FILE TEXT");
		}
	}

}