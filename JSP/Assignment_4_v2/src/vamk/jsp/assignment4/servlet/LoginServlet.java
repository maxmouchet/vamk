package vamk.jsp.assignment4.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("max") && password.equals("max")) {
            response.sendRedirect("/FileUploadServlet");
        } else {
            response.setContentType("text/html");
            response.setStatus(403);
            java.io.PrintWriter out = response.getWriter();

            out.println("<html><head>");
            out.println("<title>Login Error</title>");
            out.println("</head><body>");

            out.print("<h1>Bad credentials</h1>");
            out.println("</body></html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        java.io.PrintWriter out = response.getWriter();

        out.println("<html><head>");
        out.println("<title>Login</title>");
        out.println("</head><body>");

        out.print("<h1>Login</h1>");

        out.println("<form name='login' action='' method='post'>");
        out.print("Username: <input type='text' id='username' name='username'>");
        out.print("Password: <input type='text' id='password' name='password'>");

        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");

        out.println("</body></html>");
    }
}
