package vamk.java.assignment1;

public class Application4 {

	public static void main(String[] args) {
		int[] a = new int[50];
		
		a[0] = -1;
		a[1] = 2;
		a[2] = 5;
		
		for (int n = 0; n < a.length; n++) {
			if (n > 2) {
				a[n] = (a[n-3] + a[n-2] + a[n-1]) / 2;
			}
			
			System.out.println(a[n]);
		}
	}

}
