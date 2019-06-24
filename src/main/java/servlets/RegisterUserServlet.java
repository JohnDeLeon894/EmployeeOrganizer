package servlets;

import dao.DaoFactory;
import dao.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterUserServlet", urlPatterns = "/registeruser")
public class RegisterUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");
        String hashpass = BCrypt.hashpw(password, BCrypt.gensalt());
        String email = request.getParameter("email");
        int empID = Integer.valueOf(request.getParameter("emp_id"));
//        boolean emp_idvalidate = request.getParameterMap().containsKey("emp_id");
//        int emp_id = 0;
//        if (emp_idvalidate){
//            emp_id = Integer.valueOf(request.getParameter("emp_id"));
//        }

        // validate input
        boolean inputHasErrors =
                username.isEmpty()
                || hashpass.isEmpty()
                || password.isEmpty()
                || email.isEmpty()
                || (!password.equals(passwordConfirmation));
//
        if (inputHasErrors) {
            response.sendRedirect("/registeruser");

        } else {

            // create and save a new user
            User user = new User(username, hashpass, email, empID);
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/login");
        }
    }
}