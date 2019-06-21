package servlets;

import dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeSearchServlet", urlPatterns = "/employee-info")
public class EmployeeInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");

        request.setAttribute("emp",
                DaoFactory.empListDao().allInfo(Integer.parseInt(request.getParameter("id"))));
        request.getRequestDispatcher("WEB-INF/employee-info.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.sendRedirect("/employees-search");
        request.setAttribute("emp", DaoFactory.empListDao().allInfo(1));
        request.getRequestDispatcher("WEB-INF/employee-info.jsp").forward(request, response);

    }
}