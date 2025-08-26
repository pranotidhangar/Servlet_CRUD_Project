package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.StudentData;

@WebServlet("/DeleteStudentController")
public class DeleteStudentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteStudentController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        try {
            // Ensure parameter name matches what your delete link sends (?id=xxx)
            int id = Integer.parseInt(request.getParameter("ID"));
            int status = StudentData.DeleteData(id);

            if (status > 0) {
                pw.print("<script>alert('Student details deleted successfully');</script>");
                RequestDispatcher rd = request.getRequestDispatcher("viewStudent.html");
                rd.include(request, response);
                // Or: response.sendRedirect("viewStudent.html");
            } else {
                pw.print("<script>alert('Something went wrong');</script>");
                RequestDispatcher rd = request.getRequestDispatcher("delete.html");
                rd.include(request, response);
                // Or: response.sendRedirect("delete.html");
            }
        } catch (NumberFormatException e) {
            pw.print("<script>alert('Invalid student ID');</script>");
            RequestDispatcher rd = request.getRequestDispatcher("delete.html");
            rd.include(request, response);
        }
    }
}
