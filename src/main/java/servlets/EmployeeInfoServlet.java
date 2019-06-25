package servlets;

import dao.DaoFactory;
import dao.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeInfoServlet", urlPatterns = "/employee-info")
public class EmployeeInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String search = request.getParameter("search");

        if (request.getParameterMap().containsKey("update")) {
//            System.out.println("if hit true"); debug info
            if(request.getParameter("update").equalsIgnoreCase("true")){
//                System.out.println("second if hit true");
                String bio = request.getParameter("bio");
                String goals = request.getParameter("goals");
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("bio", bio);
                request.setAttribute("goals",goals);
                request.setAttribute("upddate", request.getParameter("update"));
                DaoFactory.empListDao().updatBio(bio,id);
                DaoFactory.empListDao().updatGoals(goals,id);
            }
        }
        request.setAttribute("emp",
                DaoFactory.empListDao().allInfo(Integer.parseInt(request.getParameter("id"))));
        request.getRequestDispatcher("WEB-INF/employee-info.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/employees-search");
        request.setAttribute("emp", DaoFactory.empListDao().allInfo(1));
        request.getRequestDispatcher("WEB-INF/employee-info.jsp").forward(request, response);
//        System.out.println("test");

    }
}