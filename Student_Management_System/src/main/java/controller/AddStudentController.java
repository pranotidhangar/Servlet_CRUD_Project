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

@WebServlet("/AddStudentController")
public class AddStudentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddStudentController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age")); 
        String stuClass = request.getParameter("stuClass");
        String address = request.getParameter("address");
        System.out.println("AddStudentController - Received:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Class: " + stuClass);
        System.out.println("Address: " + address);

        Student s = new Student(name, age, stuClass, address);
        int status = StudentData.insertStudent(s);

        if(status >= 1) {
            pw.print("<script>alert('Student Details Added Successfully');</script>");
            RequestDispatcher ts = request.getRequestDispatcher("viewStudent.html");
            ts.include(request, response);
        } else {
            pw.print("<script>alert('Failed to Add Student Details');</script>");
            RequestDispatcher ts = request.getRequestDispatcher("addStudent.html");
            ts.include(request, response);
        }
    }
}
