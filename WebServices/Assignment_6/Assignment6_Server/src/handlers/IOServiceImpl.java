package handlers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class IOServiceImpl implements IOService {

	@Override
	public Object downloadFile(String fileName) {
		Object output;
		String msgFileNotFound = "The specified file cannot be found.";

		String uploadDir = "";

		FileInputStream fileInputStream = null;
		File file = new File(uploadDir + fileName);

		byte[] fileContent = new byte[(int) file.length()];

		try {
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(fileContent);
			fileInputStream.close();

			output = fileContent;
		} catch (IOException e) {
			output = msgFileNotFound;
		}

		return output;
	}

	@Override
	public boolean uploadFile(String fileName, byte[] fileContent) {
		String uploadDir = "upload/";

		File dir = new File(uploadDir);
		dir.mkdirs();

		File file = new File(uploadDir + fileName);
		FileOutputStream fileOutputStream = null;

		try {
			file.createNewFile();

			fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(fileContent);
			fileOutputStream.close();
		} catch (IOException e) {
			return false;
		}

		return true;
	}

	@Override
	public Object listFiles() {
		Vector <String> filesList = new Vector<String>();

		File[] files = new File("./upload/").listFiles();

		for (File file : files) {
			if (file.isFile()) {
				filesList.add(file.getPath());
			}
		}

		return filesList.toArray();
	}

}
