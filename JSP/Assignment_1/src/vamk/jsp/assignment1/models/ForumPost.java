package vamk.jsp.assignment1.models;

import java.util.Calendar;
import java.util.Date;

public class ForumPost {
	
	private String username, message;
	private Date date;
	
	public ForumPost(String username, String message) {
		this.username = username;
		this.message = message;
		this.date = Calendar.getInstance().getTime();
	}

	public String getUsername() {
		return username;
	}

	public String getMessage() {
		return message;
	}

	public Date getDate() {
		return date;
	}
	
}
