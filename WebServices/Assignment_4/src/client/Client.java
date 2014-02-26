package client;

import handlers.IOService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.util.ClientFactory;

public class Client {

	public static void main(String[] args) {

		try {

			XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();

			// Here we set the server URL

			config.setServerURL(new URL(
					"http://localhost:8080/Assignment4/ioservlet"));

			config.setEnabledForExtensions(true);

			config.setEnabledForExceptions(true);

			XmlRpcClient client = new XmlRpcClient();

			client.setConfig(config);

			// In the following we call the methods through dynamic proxy
			
			ClientFactory factory = new ClientFactory(client);
			
			IOService service = (IOService) factory.newInstance(IOService.class);
			
			// byte[] content = new byte[] { (byte)0xe0, 0x4f, (byte)0xd0,
				    // 0x20, (byte)0xea, 0x3a, 0x69, 0x10, (byte)0xa2, (byte)0xd8, 0x08, 0x00, 0x2b,
				    // 0x30, 0x30, (byte)0x9d };
			
			FileInputStream fileInputStream = null;
			File file = new File("/Users/maxmouchet/Pictures/me.jpg");

			byte[] content = new byte[(int) file.length()];

			try {
				fileInputStream = new FileInputStream(file);
				fileInputStream.read(content);
				fileInputStream.close();
			} catch (IOException e) {

			}

			String fileName = "me.jpg";
			
			boolean result = service.uploadFile(fileName, content);
			
			System.out.println(result);
			
			Object dl = service.downloadFile(fileName);
			
			try {
				byte[] bytes = (byte[]) dl;
				File file2 = new File(fileName);
				FileOutputStream fileOutputStream = null;

				try {
					file2.createNewFile();
					
					fileOutputStream = new FileOutputStream(file2);
					fileOutputStream.write(bytes);
					fileOutputStream.close();
				} catch (IOException e) {
					System.out.println("Exception: " + e.getMessage());
				}
				
			} catch (Exception e) {
				System.out.println(dl);
			}

		}

		catch (Exception e)

		{

			System.out.println("Exception: " + e.getMessage());

		}

	}

}