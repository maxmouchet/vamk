package handlers;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ActionHandler implements IActionHandler {

	public Object[] listFiles(String path) {
		ArrayList<String> filesList = new ArrayList<String>();

		File[] files = new File(path).listFiles();

		for (File file : files) {
			if (file.isDirectory()) {
				filesList.add(file.getName() + File.separator);
			} else {
				filesList.add(file.getName());
			}
		}

		return (Object[]) filesList.toArray();
	}

	public String readFile(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path));
		String content = sc.useDelimiter("\\Z").next();
		sc.close();
		
		return content;
	}

	public Boolean writeFile(String path, String data, Boolean append)
			throws IOException {
		File file = new File(path);

		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getName(), append);
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write(data);
		bw.close();

		return true;
	}

}
