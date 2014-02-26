package handlers;

import java.util.Vector;

public interface IActionHandler {
	public String getDate(String name);
	
	public int getMinValue(Vector<Integer> values);
}