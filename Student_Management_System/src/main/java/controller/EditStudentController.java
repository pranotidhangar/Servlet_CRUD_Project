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

@WebServlet("/EditStudentController")
public class EditStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditStudentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		Student s = StudentData.getById(id);
		pw.print("<form action='UpdateStudentController' method='post'>");
		 pw.print("<table>");
         pw.print("<tr><td><input type='hidden' name='Id' value='" + s.getId() + "'></td></tr>");
         pw.print("<tr><th>Enter Name:</th><td><input type='text' name='Name' value='" + s.getName() + "'></td></tr>");
         pw.print("<tr><th>Enter Age:</th><td><input type='number' name='Age' value='" + s.getAge() + "'></td></tr>");
         pw.print("<tr><th>Enter Class:</th><td><input type='text' name='Student_class' value='" + s.getStudentClass()+ "'></td></tr>");
         pw.print("<tr><th>Enter Address:</th><td><input type='text' name='Address' value='" + s.getAddress() + "'></td></tr>");
         pw.print("<tr><td colspan='2'><input type='submit' value='Update'></td></tr>");
         pw.print("</table>");
	}

}
