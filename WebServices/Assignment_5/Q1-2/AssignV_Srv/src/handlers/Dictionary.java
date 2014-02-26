//This is handlers.Dictionary.java file

package handlers;

import java.util.Hashtable;
import java.util.Locale;
import java.util.Vector;

public interface Dictionary {

	public String getWord(String word, Locale locale);
	public Hashtable<String, String> getWords(Vector<String> words, Locale locale);

}