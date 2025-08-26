package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BO.Student;
import com.DAO.StudentData;

@WebServlet("/UpdateStudentController")
public class UpdateStudentController extends HttpServlet {
    private static final long serialVersionUID = 1L;
   
    public UpdateStudentController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        // Debug: Print all parameters received
        System.out.println("Debug: Received parameters -");
        System.out.println("id: " + request.getParameter("id"));
        System.out.println("name: " + request.getParameter("name"));
        System.out.println("age: " + request.getParameter("age"));
        System.out.println("stuClass: " + request.getParameter("stuClass")); // This is the key line
        System.out.println("address: " + request.getParameter("address"));

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");        
        int age = Integer.parseInt(request.getParameter("age")); 
        String stuClass = request.getParameter("stuClass"); // Make sure this matches HTML name attribute
        String address = request.getParameter("address");

        Student s = new Student(id, name, age, stuClass, address);
        int status = StudentData.updateStudent(s);

        if(status > 0) {
            pw.print("<script>alert('Data updated successfully');</script>");
            RequestDispatcher rd = request.getRequestDispatcher("viewStudent.html");
            rd.include(request, response);
        } else {
            pw.print("<script>alert('Something went wrong');</script>");
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.include(request, response);
        }
    }
}