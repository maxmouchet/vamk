//This is handlers.Dictionary.java file

package handlers;

import java.util.Hashtable;
import java.util.Vector;

public interface IOService {

	public Vector<String> getFilesList();

	// public Object[] getFilesList(String hash);
	public Hashtable<String, Object> getFiles(Vector<String> listFiles);

	public boolean putFile(Hashtable<String, byte[]> data);
}