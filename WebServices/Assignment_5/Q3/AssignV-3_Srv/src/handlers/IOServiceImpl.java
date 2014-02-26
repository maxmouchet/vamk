package handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class IOServiceImpl implements IOService {

	private String uploadDir;
	
	public IOServiceImpl() {
		uploadDir = "upload/";
	}
	public Vector<String> getFilesList() {

		File dir = new File(uploadDir);
		dir.mkdirs();
		System.out.println("getFiles");

		Vector<String> filesList = new Vector<String>();

		File[] files = new File("./upload/").listFiles();

		for (File file : files) {
			if (file.isFile()) {
				filesList.add(file.getName());
			}
		}

		return filesList;
	}

	// public Object[] getFilesList(String hash) {
	// // TODO Check hash and send "Not Modified"
	// return getFilesList();
	// }

	public Hashtable<String, Object> getFiles(Vector<String> listFiles) {
		Hashtable<String, Object> output = new Hashtable<String, Object>();
		String msgFileNotFound = "The specified file cannot be found.";

		for (String string : listFiles) {
			FileInputStream fileInputStream = null;
			File file = new File(uploadDir + string);

			byte[] fileContent = new byte[(int) file.length()];

			try {
				fileInputStream = new FileInputStream(file);
				fileInputStream.read(fileContent);
				fileInputStream.close();

				output.put(string, fileContent);
			} catch (IOException e) {
				System.out.println(file.getAbsolutePath());
				output.put(string, msgFileNotFound);
			}
		}
		return output;
	}

	public boolean putFile(Hashtable<String, byte[]> data) {
		boolean output = true;
		Enumeration<String> fileNames = data.keys();

		File dir = new File(uploadDir);
		dir.mkdirs();

		while (fileNames.hasMoreElements()) {
			String string = (String) fileNames.nextElement();
			File file = new File(uploadDir + string);
			FileOutputStream fileOutputStream = null;

			try {
				file.createNewFile();
				fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(data.get(string));
				fileOutputStream.close();
			} catch (Exception e) {
				System.err.println(e.getMessage());
				output = false;
			}
		}
		return output;
	}

}
