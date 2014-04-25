package vamk.jsp.assignment1.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vamk.jsp.assignment1.models.ForumPost;
import vamk.jsp.assignment1.models.ForumPosts;

public class SearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		String username = request.getParameter("username");
		String date = request.getParameter("date");

		response.setContentType("text/html");

		java.io.PrintWriter out = response.getWriter();

		out.println("<html><head>");
		out.println("<title>Forum Servlet</title>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\" />");
		out.println("</head><body>");

		out.print("<h1>Forum posts for username: " + username + " and date: "
				+ date + "</h1>");

		for (ForumPost post : ForumPosts.posts) {
			Boolean usernameFound = false;
			Boolean dateFound = false;

			if (username == "" || post.getUsername().equals(username)) {
				usernameFound = true;
			}

			if (date == "" || post.getDate().toString().equals(date)) {
				dateFound = true;
			}

			if (usernameFound && dateFound) {
				out.print("<p>");
				out.print("<h2>" + post.getUsername() + " at "
						+ post.getDate().toString() + "</h2>");
				out.print(post.getMessage());
				out.print("</p>");
			}
		}

		out.println("</body></html>");
	}
}
