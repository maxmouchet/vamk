package ws;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class WebService implements IWebService {

	// This is the directory path, where files are located.
	String path = "public/files/";

	public Hashtable<String, Integer> getWordCount(String wordToCount) {

		Hashtable<String, Integer> wordCount = new Hashtable<String, Integer>();

		File[] files = new File(path).listFiles();

		for (File file : files) {
			if (file.isFile()) {

				String fileName = file.getName();

				try {

					String fileContent = "";
					String line;

					BufferedReader reader = new BufferedReader(new FileReader(
							path + fileName));

					wordCount.put(fileName, 0);

					while ((line = reader.readLine()) != null)
						fileContent += line;

					// Here we define a tokenizer, which we use to distinguish
					// between
					// words and separators. In the following the space
					// character, the
					// tab character, the newline character, the carriage-return
					// character,
					// the form-feed character and dot (.) are set as
					// separators.
					StringTokenizer tokenizer = new StringTokenizer(
							fileContent, " \t\n\r\f.");

					// In the following we go through the tokenizer and
					// extract words one by one
					while (tokenizer.hasMoreElements()) {
						String word = tokenizer.nextElement().toString();

						if (word.equals(wordToCount)) {
							int counter = wordCount.get(fileName);
							counter++;
							wordCount.put(fileName, counter);
						}
					}
				} catch (FileNotFoundException e) {
					wordCount.put(e.getMessage(), -1);
				} catch (IOException e) {
					wordCount.put(e.getMessage(), -1);
				}
			}
		}

		return wordCount;

	}

}