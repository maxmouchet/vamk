package vamk.jsp.assignment1.servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vamk.jsp.assignment1.models.ForumPost;
import vamk.jsp.assignment1.models.ForumPosts;

public class ForumServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		response.setContentType("text/html");

		java.io.PrintWriter out = response.getWriter();

		out.println("<html><head>");
		out.println("<title>Forum Servlet</title>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\" />");
		out.println("</head><body>");

		out.print("<h1>All forum posts</h1>");

		for (ForumPost post : ForumPosts.posts) {
			out.print("<p>");
			out.print("<h2>" + post.getUsername() + " at "
					+ post.getDate().toString() + "</h2>");
			out.print(post.getMessage());
			out.print("</p>");
		}

		out.println("</body></html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String message = request.getParameter("message");

		ForumPosts.posts.add(new ForumPost(username, message));
		
		doGet(request, response);
	}

}
