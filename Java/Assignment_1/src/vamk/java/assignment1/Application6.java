package vamk.java.assignment1;

import java.util.HashMap;

public class Application6 {

	public static void main(String[] args) {
		HashMap<String, Integer> months = new HashMap<String, Integer>();

		months.put("January", 31);
		months.put("February", 28);
		months.put("March", 31);
		months.put("April", 30);
		months.put("May", 31);
		months.put("June", 30);
		months.put("July", 31);
		months.put("August", 31);
		months.put("September", 30);
		months.put("October", 31);
		months.put("November", 30);
		months.put("December", 31);
		
		for (String month : months.keySet()) {
			switch (months.get(month)) {
			case 31:
				System.out.println(month);
				break;

			default:
				break;
			}
		}
	}

}
