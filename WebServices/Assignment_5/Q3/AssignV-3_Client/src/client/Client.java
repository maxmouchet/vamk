//This is client.Client.java file

package client;

import handlers.IOService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.util.ClientFactory;

public class Client {

	private XmlRpcClient client;
	private IOService wService;

	public Client() {
		try {

			XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();

			config.setServerURL(new URL(
					"http://localhost:8080/AssignV-3_Srv/myxmlrpc"));
			config.setEnabledForExtensions(true);
			config.setEnabledForExceptions(true);

			client = new XmlRpcClient();
			client.setConfig(config);

			ClientFactory factory = new ClientFactory(client);
			wService = (IOService) factory.newInstance(IOService.class);
		}

		catch (Exception e)

		{

			System.out.println("Exception: " + e.getMessage());

		}

	}

	public Vector<String> getListFile() {
		return (Vector<String>) this.wService.getFilesList();
	}

	public void putFiles(Vector<ShowFile> listFiles) {
		Hashtable<String, byte[]> data = new Hashtable<String, byte[]>();
		for (ShowFile showFile : listFiles) {

			FileInputStream fileInputStream = null;
			File file = new File(showFile.getLocation());
			byte[] fileContent = new byte[(int) file.length()];

			try {
				fileInputStream = new FileInputStream(file);
				fileInputStream.read(fileContent);
				fileInputStream.close();

				data.put(showFile.toString(), fileContent);
			} catch (IOException e) {
				System.err.println("File not found !");
			}
		}
		if (!this.wService.putFile(data)) {
			System.err.println("Some files fail !");
		}
	}

	public void pullFiles(Vector<ShowFile> listFiles) {
		String uploadDir = "upload/";
		Vector<String> listSend = new Vector<String>();
		Hashtable<String, Object> tmpSaveFiles = new Hashtable<String, Object>();
		Enumeration<String> filesName;

		for (ShowFile sf : listFiles)
			listSend.add(sf.toString());

		tmpSaveFiles = wService.getFiles(listSend);
		filesName = tmpSaveFiles.keys();

		File dir = new File(uploadDir);
		dir.mkdirs();
		System.out.println(dir.getAbsoluteFile());

		while (filesName.hasMoreElements()) {
			String string = (String) filesName.nextElement();
			try {
				byte[] data = (byte[]) tmpSaveFiles.get(string);
				File file = new File(uploadDir + string);
				FileOutputStream fileOutputStream = null;

				try {
					file.createNewFile();
					fileOutputStream = new FileOutputStream(file);
					fileOutputStream.write(data);
					fileOutputStream.close();
				} catch (Exception e) {
					System.err.println("File: " + string + " fail to save");
				}
			} catch (Exception e) {
				System.err.println("File: " + string + " fail to pull");
				System.err.println((String) tmpSaveFiles.get(string));
			}
		}

	}
}