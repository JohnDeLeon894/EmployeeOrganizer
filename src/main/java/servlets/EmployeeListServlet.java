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
       /* System.out.printf("Post request hit with following parameters: %s %s %n",
                request.getParameter("pagenum"), request.getParameter("perpage"));//debug info
//        set up vars incase none are passed
        int perPage = 6;
        int pageNum = 1;
        String pageNumParam= request.getParameter("pagenum"); //since I am calling this a lot I
        // got tired of typing out the whole thing.
        String perPageParam= request.getParameter("perpage");//since I am calling this a lot I
        // got tired of typing out the whole thing.
        if (request.getParameterMap().containsKey("perpage")) {
            System.out.println("perpage if started");
            int pageNumNum = Integer.parseInt( pageNumParam.split(" ")[0]) ;// split to array and
            // pull first element. This should be the current number.
            perPage = Integer.parseInt(perPageParam);
            System.out.println("perpage completed");
            if(pageNumParam.contains("-")){ // if this contains a - symbol that means the
                // previous page button was pressed. so now we subtract pagenum by 1.
                pageNum = --pageNumNum;
                if(pageNum<1){
                    pageNum =1;
                }
            }
        }
        if (request.getParameterMap().containsKey("pagenum")) {
            System.out.println("pagenum if started");
            int pageNumNum = Integer.parseInt( pageNumParam.split(" ")[0]) ;// split to array and
            // pull first element. This should be the current number.
            System.out.println("perpage char at index 0 = "+pageNumNum);
            if(pageNumParam.contains("+")){// if this contains a + symbol that means the
                // previous page button was pressed. so now we add pagenum by 1.
                pageNum = ++pageNumNum;
            }
        }
//        setting the page attributes.
        request.setAttribute("perpage", perPage);
        request.setAttribute("pagenum", pageNum);
        request.setAttribute("emp", DaoFactory.empListDao().all(perPage, pageNum));
        request.getRequestDispatcher("WEB-INF/employees-list.jsp").forward(request, response);
        System.out.println("do post method completed.");// debug info*/

        String search = request.getParameter("search");
        String type = request.getParameter("stype");

        if(type.equals("name")){
            request.setAttribute("emp", DaoFactory.empListDao().searchName(search));
            System.out.println( "name if triggered");
        }
        if(type.equals("id")){
            System.out.println( "id if triggered");
            request.setAttribute("emp", DaoFactory.empListDao().searchID(search));

        }
        if(type.equals("dept")){
            request.setAttribute("emp", DaoFactory.empListDao().searchDept(search));
            System.out.println( "dept if triggered");
        }


        request.getRequestDispatcher("WEB-INF/employees-list.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        System.out.println(" do get started");

        //int perPage = 6;
        //int pageNum = 1;
        System.out.printf("get request hit with following parameters: %s %s %n",
                request.getAttribute("pagenum"), request.getParameter("perpage"));

        //request.setAttribute("perpage",perPage);
        // request.setAttribute("pagenum", pageNum);

        request.setAttribute("emp", DaoFactory.empListDao().all());
        request.getRequestDispatcher("WEB-INF/employees-list.jsp").forward(request, response);

        System.out.printf("get request completed with following parameters: pagenum: %s perpage: %s %n",
                request.getAttribute("pagenum"), request.getParameter("perpage"));
    }
}