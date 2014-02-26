package ws;

import java.util.Hashtable;

public interface IWebService {

	// This is the prototype of getWordList() method.
	public Hashtable<String, Integer> getWordCount(String wordToCount);
}
