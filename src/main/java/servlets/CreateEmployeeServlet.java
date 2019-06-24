package servlets;


import dao.DaoFactory;
import dao.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;


@WebServlet(name = "CreateEmployeeServlet", urlPatterns = "/registeremployee")
public class CreateEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/create_employee.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String gender = request.getParameter("gender");
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        Date DOB = Date.valueOf(request.getParameter("birth_date"));
        Date hireDate = Date.valueOf(request.getParameter("hire_date"));
        double salary = Double.parseDouble(request.getParameter("salary"));
        String bio = request.getParameter("bio");
        String goals = request.getParameter("goals");
        int departmentId = Integer.valueOf(request.getParameter("dept_id"));
        int jobId = Integer.valueOf(request.getParameter("job_id"));


        // validate input
        boolean inputHasErrors = gender.isEmpty()
                || firstName.isEmpty()
                || lastName.isEmpty();

        if (inputHasErrors) {
            response.sendRedirect("/registeremployee");
            return;
        }

        // create and save a new user
        Employee emp = new Employee( gender, firstName, lastName, DOB, hireDate, salary, bio, goals, departmentId, jobId);
        DaoFactory.empListDao().insert(emp);
        response.sendRedirect("/registeremployee");
    }
}
