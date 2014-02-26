//This is ws.Calculator.java file.

package ws;

import java.util.Random;
import java.util.Vector;

public class Calculator implements ICalculator {

	double digits = 10000.0;

	public Vector<Double> getNumbers(int length) {

		Vector<Double> v = new Vector<Double>(length);
		Random r = new Random();

		// Here we randomly initialize the vector.
		for (int i = 0; i < length; i++)
			v.add((Math.round(digits * r.nextDouble())) / digits);

		return v;

	}

	public Vector<Double> mutateNumbers(Vector<Double> v) {

		Random r = new Random();

		// Here we randomly select an index of the vector.
		int index = r.nextInt(v.size());

		// Here we change the value of the selected index of
		// the vector.
		v.set(index, (Math.round(digits * r.nextDouble())) / digits);

		return v;

	}

	public Vector<Double> swapRand(Vector<Double> v0, Vector<Double> v1) {
		Random r = new Random();
		int loop = r.nextInt(100);

		for (int i = 0; i < loop; i++) {
			int index = r.nextInt(10);
			double tmp = v0.get(index);
			v0.set(index, v1.get(index));
			v1.set(index, tmp);
		}

		Vector<Double> listVector = new Vector<Double>();
		listVector.addAll(v0);
		listVector.add(-1.0);
		listVector.addAll(v1);

		return listVector;
	}

}
