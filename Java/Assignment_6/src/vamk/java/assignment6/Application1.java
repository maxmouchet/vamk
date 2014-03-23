package vamk.java.assignment6;

import java.util.Random;
import java.util.Scanner;

public class Application1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter an integer between 0 and 50: ");
		int userNumber = sc.nextInt();
		
		Random randomGenerator = new Random();
		boolean found = false;
		
	    for (int i = 0; i < 10 && !found; i++){
	      if (randomGenerator.nextInt(50) == userNumber) {
	    	  System.out.println("Number found !");
	    	  found = true;
	      }
	    }
	    
	    if (!found) {
	    	System.out.println("Number not found !");
	    }

	}

}
