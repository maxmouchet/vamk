package vamk.jsp.assignment3.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		response.setContentType("text/html");

		java.io.PrintWriter out = response.getWriter();

		out.println("<html><head>");
		out.println("<title>Download Servlet</title>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\" />");
		out.println("</head><body>");

		out.print("<h1>Downloadable files</h1>");
		
		out.println("<form name='files' action='' method='post'>");
	
		File folder = new File(".");
		for (final File fileEntry : folder.listFiles()) {
			if (!fileEntry.isDirectory()) {
				out.print("<input type='radio' ");
				out.print("name='file' ");
				out.print("value='" + fileEntry.getName() + "' ");
				out.print(">");
				out.print(fileEntry.getName());
				out.print("<br>");
			}
		}
		
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");

		out.println("</body></html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String file = request.getParameter("file");
		
		MimetypesFileTypeMap MimeMap = new MimetypesFileTypeMap();
		
		response.setContentType(MimeMap.getContentType(file));
		
		InputStream input = new FileInputStream(file);
		
		for(int x=input.read(); x!=-1; x=input.read()){
			response.getOutputStream().write(x);
	    }
	}

}
