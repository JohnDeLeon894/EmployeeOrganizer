package servlets;

import dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeSearchServlet", urlPatterns = "/employee-search")
public class EmployeeSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");

        request.setAttribute("emps", DaoFactory.empListDao().searchName(search));
        request.getRequestDispatcher("WEB-INF/employees-list.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.sendRedirect("/employees-search");
        request.setAttribute("emps", DaoFactory.empListDao().all());
        request.getRequestDispatcher("WEB-INF/employee-search.jsp").forward(request, response);

    }
}
