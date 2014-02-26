//This is ws.Calculator.java file.

package ws;

import java.util.Collections;
import java.util.Vector;

public class Calculator implements ICalculator {

	public Vector<Integer> getPrimeList(int lower, int upper) {
		Vector<Integer> primeList = new Vector<Integer>();
		for (int i = lower; i < upper; i++)
			if (isPrime(i))
				primeList.add(i);
		return primeList;
	}

	private static boolean isPrime(int number) {
		for (int i = 2; i < number; i++) {
			if (number % i == 0)
				return false;
		}
		return (number > 1);
	}

	public Vector<String> sortString(Vector<String> list, String order) {
		Collections.sort(list);
		if(order == "d"){
			Collections.reverse(list);
		}
		return list;
	}
}