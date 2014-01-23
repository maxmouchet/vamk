package vamk.java.assignment1;

import java.util.Vector;

public class Application3 {

	public static void main(String[] args) {
		System.out.println("Primes under 1000:");
		for (Integer prime : getPrimeList(0, 1000)) {
			System.out.println(prime);
		}
	}

	public static Vector<Integer> getPrimeList(int lower, int upper) {
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

}
