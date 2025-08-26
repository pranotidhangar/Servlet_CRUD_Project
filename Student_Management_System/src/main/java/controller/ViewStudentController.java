package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.BO.Student;
import com.DAO.StudentData;

@WebServlet("/ViewStudentController")
public class ViewStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewStudentController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		List<Student> list = StudentData.viewStudent();
       pw.print("<table border = '1'>");
		
		pw.print("<tr> <th>Id </th>  <th>Name</th>  <th>Age</th>  <th>Class</th>  <th>Address</th> <th>Edit</th> <th> delete</th> </tr>");
		
		for(Student e : list)
		{
			pw.print("<tr> <td>"+ e.getId()+ " </td>  <td>"+e.getName()+"</td>  <td>"+e.getAge()+"</td>  <td>"+e.getStudentClass()+"</td>  <td>"+e.getAddress()+"</td>"
					+ "<td><a href='update.html?id=" + e.getId() + "'>Edit</a></td>"
				    + "<td><a href=DeleteStudentController?ID="+e.getId()+">Delete</a> </td>");
		}	 
		pw.print("</table>");
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
