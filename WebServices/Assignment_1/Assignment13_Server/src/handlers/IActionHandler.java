package handlers;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IActionHandler {
	
	public Object[] listFiles(String path);
	
	public String readFile(String path) throws FileNotFoundException;
	
	public Boolean writeFile(String path, String data, Boolean append) throws IOException;
	
}