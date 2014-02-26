package handlers;

import java.util.Vector;

public interface IOService {

	public Object listFiles();
	public Object downloadFile(String fileName);
	public boolean uploadFile(String fileName, byte[] fileContent);
	
}
