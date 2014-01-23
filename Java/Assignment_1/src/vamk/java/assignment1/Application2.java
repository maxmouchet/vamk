package vamk.java.assignment1;

public class Application2 {

	public static void main(String[] args) {
		// Number of terms to print
		final int n = 10;
		
		System.out.println("Printing Fibonnaci series");
		fibo(n, 0, 1);

		System.out.println("\n\nPrinting Tribonnaci series");
		tribo(n, 0, 0, 1);

		System.out.println("\n\nPrinting 1 3 4 6 14 9 37 12 series");
		serie3(n);
	}

	private static int fibo(int n, int fn_1, int fn) {
		System.out.print(fn + " ");

		if (n == 0) {
			return fn;
		} else {
			return fibo(n - 1, fn, fn + fn_1);
		}
	}

	private static int tribo(int n, int fn_1, int fn_2, int fn) {
		System.out.print(fn + " ");

		if (n == 0) {
			return fn;
		} else {
			return tribo(n - 1, fn_2, fn, fn + fn_1 + fn_2);
		}
	}

	private static void serie3(int n) {
		int sum = 1;
		int add = 3;
		
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0) {
				System.out.print(add + " ");
				add += 3;
			} else {
				System.out.print(sum + " ");
				if (sum != 1) { sum += sum; }
				sum += add;
			}
		}
	}
}
