package vamk.java.assignment2;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Person[] persons = new Person[2];
		
		for (int i = 0; i < persons.length; i++) {
			Scanner sc = new Scanner(System.in);
			
			String name;
			float height, weight;
			
			System.out.println("\nEnter informations for person " + i);
			
			System.out.print("Name: ");
			name = sc.nextLine();
			
			System.out.print("Height (m): ");
			height = sc.nextFloat();
			
			System.out.print("Weight (kg): ");
			weight = sc.nextFloat();
			
			persons[i] = new Person(name, height, weight);
		}
		
		for (int i = 0; i < persons.length; i++) {
			System.out.println("\nPerson " + i + " is " + persons[i].identify());
			System.out.println("Info: \n" + persons[i].display());
		}
		
		// Test clone
		Person clone = new Person(persons[0]);
		System.out.println("\nLook at my clone: \n" + clone.display());
		
		// Who's the biggest ?
		Person biggie = persons[0].compareWeight(persons[1]);
		System.out.println("\nBiggie: \n" + biggie.display());
		
		// Upper limit
		System.out.println("\n" + persons[0].limitWeight(55));
	}

}
