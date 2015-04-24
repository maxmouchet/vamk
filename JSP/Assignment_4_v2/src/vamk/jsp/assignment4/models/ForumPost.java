package vamk.jsp.assignment4.models;

import java.util.Calendar;
import java.util.Date;

public class ForumPost {

    private String username, message, filePath;
	private Date date;
	
	public ForumPost(String username, String message, String filePath) {
		this.username = username;
		this.message = message;
        this.filePath = filePath;
		this.date = Calendar.getInstance().getTime();
	}

	public String getUsername() {
		return username;
	}

	public String getMessage() {
		return message;
	}

	public String getFilePath() { return filePath; }

    public Date getDate() {
		return date;
	}
	
}