package vamk.java.assignment6;

import java.util.Date;

public class Entry {
	
	private String name;
	private String comment;
	private Date date;
	
	public Entry(String name, String comment, Date date) {
		this.name = name;
		this.comment = comment;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public String getComment() {
		return comment;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Entry [name=" + name + ", comment=" + comment + ", date="
				+ date + "]";
	}
	
}
