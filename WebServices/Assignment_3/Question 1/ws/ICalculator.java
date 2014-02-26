//This is ws.ICalculator.java file.

package ws;

import java.util.Vector;

public interface ICalculator {

	public Vector<Double> getNumbers(int length);

	public Vector<Double> mutateNumbers(Vector<Double> v);
	
	public Vector<Double> swapRand(Vector<Double> v0, Vector<Double> v1);
}
