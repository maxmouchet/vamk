package vamk.java.assignment6;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application2 {
	
	private static enum choice {
		UNKNOWN,
		CONTINUE,
		SEARCH,
		EXIT
	}
	
	private static ArrayList<Entry> entries = new ArrayList<Entry>();
	
	public static void main(String[] args) throws Exception {
		choice userChoice = choice.UNKNOWN;

		do {
			userChoice = ask();
			
			switch(userChoice) {
			case CONTINUE:
				addEntry();
				break;
			
			case SEARCH:
				searchEntry();
				break;
			}
		} while (userChoice != choice.EXIT);
	}
	
	private static void addEntry() throws Exception {
		Scanner sc = new Scanner(System.in);
		Pattern p = Pattern.compile(".*[^a-zA-Z0-9 ].*");
		
		String name = "";
		String comment = "";
		Date date = new Date();
		
		System.out.println("\n");
		
		System.out.print("Name: ");
		name = sc.nextLine();

	    if (p.matcher(name).matches()) {
	    	throw new Exception("Special characters not allowed");
	    }
		
		System.out.print("Comment: ");
		comment = sc.nextLine();
		
		if (p.matcher(comment).matches()) {
	    	throw new Exception("Special characters not allowed");
	    }
		
		entries.add(new Entry(name, comment, date));
	}
	
	private static void searchEntry() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		for (Entry entry : entries) {
			if (entry.getName().equals(name)) {
				System.out.println(entry);
			}
		}
	}
	
	private static choice ask() {
		Scanner sc = new Scanner(System.in);
		choice userChoice = choice.UNKNOWN;
		
		System.out.println("\n");
		System.out.println("1. Add entry");
		System.out.println("2. Search entry");
		System.out.println("0. Exit");
		System.out.print("\nChoice (0, 1, 2): ");
		
		switch(sc.nextInt()) {
		case 0:
			userChoice = choice.EXIT;
			break;
		
		case 1:
			userChoice = choice.CONTINUE;
			break;
		
		case 2:
			userChoice = choice.SEARCH;
			break;
		
		default:
			userChoice = choice.UNKNOWN;
			break;
		}
		
		
		return userChoice;
	}

}
