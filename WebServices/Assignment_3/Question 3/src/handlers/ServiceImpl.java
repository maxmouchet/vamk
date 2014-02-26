package handlers;

import java.io.File;
import java.util.Hashtable;

public class ServiceImpl implements Service {

	public Hashtable<String, Long> getFilesLength() {
		Hashtable<String, Long> filesLength = new Hashtable<String, Long>();
		
		File[] files = new File(".").listFiles();

		for (File file : files) {
			if (file.isFile()) {
				filesLength.put(file.getName(), file.length());
			}
		}
		
		return filesLength;
	}

}
