//This is ws.ICalculator.java file.

package ws;

import java.util.Vector;

public interface ICalculator {

	public Vector<Integer> getPrimeList(int lower, int upper);

	public Vector<String> sortString(Vector<String> list, String order);

}