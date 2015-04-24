package vamk.jsp.assignment4.servlet;

import com.oreilly.servlet.MultipartRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ForumServlet extends HttpServlet {
    private String fileRepositoryPath;

    public void init() {

		/*
		 * Below we set the path for the directory where uploaded files are
		 * saved getServletContext().getRealPath(separator) returns the path to
		 * the root directory of the servlet. Variable separator indicates the
		 * directory separator on the system.
		 */

        String separator = System.getProperty("file.separator");

        fileRepositoryPath = getServletContext().getRealPath(separator)
                + getServletContext().getInitParameter("upload_dir")
                + separator;

        // Here we create the uploaded_files directory if it does not exist.
        File repositoryDirectory = new File(fileRepositoryPath);
        if (!repositoryDirectory.exists())
            repositoryDirectory.mkdir();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Here we set the limit size of 4 MB and upload the files
		 */

            MultipartRequest multipartRequest = new MultipartRequest(request,
                    fileRepositoryPath, 4 * 1024 * 1024);

            // Here we read the names of the files to an enumeration
            Enumeration<String> fileEnumerator = multipartRequest.getFileNames();

            response.setContentType("text/html");

            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>File Upload Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>" + fileRepositoryPath + "</p>");
            out.println("Uploaded files are:<br>");
            // Here we begin an unordered list
            out.println("<ul>");
            StringBuilder uploadedFiles = new StringBuilder();
            while (fileEnumerator.hasMoreElements()) {
                String fileName = multipartRequest
                        .getFilesystemName((String) fileEnumerator.nextElement());
                uploadedFiles.append("<li>" + fileName);
            }

            // Here we print the list of files.
            out.println(uploadedFiles);

            // Here we end the unordered list
            out.println("</ul>");
            out.println("<hr>");
            out.println("<a href='index.html'>Back to File Upload Page</a>");
            out.println("</body>");
            out.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        <form action='FileUploadServlet' method='post' enctype='multipart/form-data'>
//        <table;
//        border='0'>
//
//        <tr><th valign='top'>Please select the file:</th>
//
//        <td><input name='fileName' type='file'> </td></tr>
//
//        <tr><td></td><td><input type='submit' value='Upload File'></td></tr>
//        </table>
//        </form>
    }
}
