//This is client.Client.java file

package client;

import handlers.Dictionary;

import java.awt.EventQueue;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Vector;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.util.ClientFactory;

public class Client {

	private static XmlRpcClientConfigImpl config;
	private static XmlRpcClient client;

	public static void main(String[] args) {

		try {

			config = new XmlRpcClientConfigImpl();

			config.setServerURL(new URL(
					"http://localhost:8080/AssignV_Srv/auth_xmlrpc"));

			config.setEnabledForExtensions(true);

			config.setEnabledForExceptions(true);

		}

		catch (Exception e)

		{

			System.out.println("Exception: " + e.getMessage());

		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public static void auth(String user, String password) {
		config.setBasicUserName(user);
		config.setBasicPassword(password);

		client = new XmlRpcClient();

		client.setConfig(config);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrom frame = new MainFrom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static String getTranslation(String words, Locale locale){
		ClientFactory factory = new ClientFactory(client);

		Dictionary myDictionary = (Dictionary) factory
				.newInstance(Dictionary.class);
		Hashtable<String, String> listTranslation = myDictionary.getWords(new Vector<String>(Arrays.asList(words.split(","))), locale);
		
		String output = "";
		Enumeration<String> keys = listTranslation.keys();
		while(keys.hasMoreElements()){
			String key = keys.nextElement();
			output += key + ": " + listTranslation.get(key) + "\n";
		}
		
		return output;
	}
	
	public static String fiToEn(String words) {
		Locale locale = new Locale("en", "GB");
		return getTranslation(words, locale);
		
	}

	public static String enToFi(String words) {
		Locale locale = new Locale("fi", "FI");
		return getTranslation(words, locale);
	}
}
