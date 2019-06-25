package servlets;

import dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeUpdateServlet", urlPatterns = "/employee-goals-bio-form")
public class EmployeeUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setAttribute("user", request.getSession().getAttribute("user"));
        request.setAttribute("emp",
                DaoFactory.empListDao().allInfo(Integer.parseInt(request.getParameter("id"))));
        request.setAttribute("emp", request.getAttribute("emp"));

        request.getRequestDispatcher("/WEB-INF/employee-goals-bio-form.jsp").forward(request, response);
    }
}
