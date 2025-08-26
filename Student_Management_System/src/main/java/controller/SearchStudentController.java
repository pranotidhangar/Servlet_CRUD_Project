package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BO.Student;
import com.DAO.StudentData;

@WebServlet("/SearchStudentController")
public class SearchStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public SearchStudentController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	        PrintWriter pw = response.getWriter();

	        String name = request.getParameter("name");
	        Student s = StudentData.searchStudent(name); 

	        if (s == null) {
	            pw.println("<p style='color:red;text-align:center;'>No student found with name: " + name + "</p>");
	        } else {
	            pw.println("<table>");
	            pw.println("<tr><th>ID</th><th>Name</th><th>Age</th><th>Class</th><th>Address</th><th>Edit</th><th>Delete</th></tr>");
	            pw.println("<tr>"
	                     + "<td>" + s.getId() + "</td>"
	                     + "<td>" + s.getName() + "</td>"
	                     + "<td>" + s.getAge() + "</td>"
	                     + "<td>" + s.getStudentClass() + "</td>"
	                     + "<td>" + s.getAddress() + "</td>"
	                     + "<td><a href='EditStudentController?ID=" + s.getId() + "'>Edit</a></td>"
	                     + "<td><a href='DeleteStudentController?ID=" + s.getId() + "'>Delete</a></td>"
	                     + "</tr>");
	            pw.println("</table>");
	        }

	        pw.close();
	    }

	
}
