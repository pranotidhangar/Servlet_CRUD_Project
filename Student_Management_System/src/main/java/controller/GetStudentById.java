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

@WebServlet("/GetStudentById")
public class GetStudentById extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        int id = Integer.parseInt(request.getParameter("id"));
        Student s = StudentData.getById(id);
        
        System.out.println("Debug: Student retrieved - " + s); // Debug line
        if (s != null) {
            System.out.println("Debug: Student class value - " + s.getStudentClass()); // Debug line
        }

        if (s != null) {
            String json = "{"
                + "\"id\":" + s.getId() + ","
                + "\"name\":\"" + s.getName() + "\","
                + "\"age\":" + s.getAge() + ","
                + "\"stuClass\":\"" + (s.getStudentClass() != null ? s.getStudentClass() : "") + "\","
                + "\"address\":\"" + s.getAddress() + "\""
                + "}";
            System.out.println("Debug: JSON response - " + json); // Debug line
            response.getWriter().write(json);
        } else {
            response.getWriter().write("{}");
        }
    }
}