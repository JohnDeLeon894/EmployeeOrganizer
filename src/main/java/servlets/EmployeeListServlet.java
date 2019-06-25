package servlets;

import dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "Servlet", urlPatterns = "/employees-list")
public class EmployeeListServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//        System.out.println("DOPOST started"); debug info
        String search = request.getParameter("search");
        String type = request.getParameter("stype");


        if(type.equals("name")){
            request.setAttribute("emp", DaoFactory.empListDao().searchName(search));
//            System.out.println( "name if triggered"); debug info
        }
        if(type.equals("id")){
//            System.out.println( "id if triggered"); debug info
            request.setAttribute("emp", DaoFactory.empListDao().searchID(search));

        }
        if(type.equals("dept")){
            request.setAttribute("emp", DaoFactory.empListDao().searchDept(search));
//            System.out.println( "dept if triggered"); debug info
        }
        if (type.equals("delete")){
//            System.out.println( "delete if started"); debug info
            int id = Integer.parseInt(request.getParameter("id"));
//            System.out.println("after parse" +id); debug info
            DaoFactory.empListDao().delete(id);
            request.setAttribute("emp", DaoFactory.empListDao().all());
        }


        request.getRequestDispatcher("WEB-INF/employees-list.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("isadmin") == null) {
            response.sendRedirect("/login");
            return;
        }

//        System.out.println(" do get started");

        //int perPage = 6;
        //int pageNum = 1;
//        System.out.printf("get request hit with following parameters: %s %s %n",
//                request.getAttribute("pagenum"), request.getParameter("perpage"));

        //request.setAttribute("perpage",perPage);
        // request.setAttribute("pagenum", pageNum);

        request.setAttribute("emp", DaoFactory.empListDao().all());
        request.getRequestDispatcher("WEB-INF/employees-list.jsp").forward(request, response);

//        System.out.printf("get request completed with following parameters: pagenum: %s perpage: %s %n",
//                request.getAttribute("pagenum"), request.getParameter("perpage"));
    }
}