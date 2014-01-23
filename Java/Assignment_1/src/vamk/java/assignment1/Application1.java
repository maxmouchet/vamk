package vamk.java.assignment1;

public class Application1 {

	public static void main(String[] args) {
		System.out.print("Sum of the numbers in [1;249]:");
		
		int result = 0;
		for (int i = 1; i <= 249; i++) {
			result += i;
		}
		
		System.out.println(result);
	}

}
