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

@WebServlet(name = "RegisterEmployeeServlet", urlPatterns = "/registeruser")
public class RegisterEmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String hashpass = BCrypt.hashpw(password, BCrypt.gensalt());
        String passwordConfirmation = request.getParameter("confirm_password");
        String hashconfirmpass = BCrypt.hashpw(passwordConfirmation, BCrypt.gensalt());
        String email = request.getParameter("email");
        boolean emp_idvalidate = request.getParameterMap().containsKey("emp_id");
        int emp_id = 0;
        if (emp_idvalidate){
            emp_id = Integer.valueOf(request.getParameter("emp_id"));
        }

        // validate input
        boolean inputHasErrors = username.isEmpty()
                || hashpass.isEmpty()
                || email.isEmpty()
                || (! hashpass.equals(hashconfirmpass));

        if (inputHasErrors) {
            response.sendRedirect("/register");
            return;
        }

        // create and save a new user
        User user = new User(username, password, email, emp_id);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
    }
}