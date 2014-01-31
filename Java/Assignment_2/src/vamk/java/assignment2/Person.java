package vamk.java.assignment2;

public class Person {
	
	private String name;
	private float height, weight;
	
	public Person(String name, float height, float weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	
	public Person(Person p) {
		this.name = p.name;
		this.height = p.height;
		this.weight = p.weight;
	}
	
	public String display() {
		String output = "";
		
		output += "Name: " + this.name;
		output += "\nHeight (m): " + this.height;
		output += "\nWeight (kg): " + this.weight;
		
		return output;
	}
	
	public String identify() {
		float BMI =  weight / (height*height);
		String result = "Unknown";
		
		if (BMI < 20) {
			result = "Underweight";
		} else if (20 <= BMI && BMI < 24.99) {
			result = "Normal weight";
		} else if (25 <= BMI && BMI < 29.99) {
			result = "Slightly overweight";
		} else if (30 <= BMI && BMI < 39.99) {
			result = "Significantly overweight";
		} else if (BMI >= 40) {
			result = "Obesity";
		}
		
		return result;
	}
	
	public Person compareWeight(Person p) {
		Person result = this;
		
		if (p.weight > this.weight) {
			result = p;
		}
		
		return result;
	}
	
	public Person limitWeight(float limit) {
		Person result = null;
		
		if (this.weight < limit) {
			result = this;
		}
		
		return result;
	}
}
