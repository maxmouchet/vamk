//This is handlers.DictionaryImpl.java file

package handlers;

import java.util.Hashtable;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

public class DictionaryImpl implements Dictionary {

	public String getWord(String word, Locale locale) {

		/*
		 * Here we create a ResourceBundle object, whose base name is dictionary
		 * 
		 * and resides under WEB-INF/classes/dict/ directory of the web
		 * application.
		 * 
		 * The locale parameter specifies the name of the ResourceBundle object
		 * precisely,
		 * 
		 * like dictionary_fi_FI, or dictionary_en_GB.
		 */

		ResourceBundle resourceBundle = ResourceBundle.getBundle(
				"dict.dictionary", locale);

		// Here we get the equivalent of 'word' from the resource bundle file

		String translation = resourceBundle.getString(word.replace(' ', '_'));

		return translation;

	}

	public Hashtable<String, String> getWords(Vector<String> words,
			Locale locale) {
		ResourceBundle resourceBundle = ResourceBundle.getBundle(
				"dict.dictionary", locale);
		Hashtable<String, String> translations = new Hashtable<String, String>();
		// Here we get the equivalent of 'word' from the resource bundle file
		for (String word : words) {
			word = word.trim();
			translations.put(word, resourceBundle.getString(word.replace(' ', '_')));
		}

		return translations;
	}

}
