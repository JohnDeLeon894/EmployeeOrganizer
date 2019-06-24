package dao;

import com.mysql.jdbc.Driver;
import mysql.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeesDao implements Employees {
    /*
     *
     * Create a class named dao.EmployeesDao that implements the Ads interface
     * This class should have a private instance property named connection of type Connection that is
     * initialized in the constructor. Define your constructor so that it accepts an instance of
     * your Config class so that it can obtain the database credentials.
     * Implement the methods in the Ads interface
     * Your methods should retrieve ads from the database and insert new ads into the database
     * The connection object will be created just once, in this class' constructor, and the individual
     * methods that query the database should use the connection object to create statements.
     */
    private Config config = new Config();
    private Connection connection;


    public static void main(String[] args) {
        Employee emp = DaoFactory.empListDao().allInfo(1);
        for (String member: emp.getTeam()) {
            System.out.println(member);
        }
    }

    public EmployeesDao() {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUserName(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Employee> all(int perPage, int pageNum) {
        List<Employee> employeesList = new ArrayList<Employee>();
        System.out.println("perpage starts at " + perPage);
        try {
            Statement stmt = connection.createStatement();
            //perPage-=2;
            System.out.println("perpage before query string = " + perPage);

            String query = String.format("SELECT * FROM employees limit %d offset %d", perPage,
                    (pageNum * perPage) - perPage);
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setFirst_name(rs.getString("first_name"));
                emp.setLast_name(rs.getString("last_name"));
                emp.setId(rs.getInt("id"));
                emp.setGender(rs.getString("gender"));
                emp.setBirth_date(rs.getDate("birth_date"));
                emp.setHire_date(rs.getDate("hire_date"));

                employeesList.add(emp);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return employeesList;
    }

    public List<Employee> all() {
        List<Employee> employeesList = new ArrayList<Employee>();
//        System.out.println("perpage starts at " + perPage);


        String formatQuery = String.format("SELECT * FROM employees ");
        employeesList = processEmpList(formatQuery);


        return employeesList;
    }

    @Override
    public List<Employee> searchName(String searchQuery) {
        System.out.println("search by name started");
        List<Employee> employeesList;
        String sQFirst = "";
        String sQSecond = "";
        String[] spltQuery = searchQuery.split(" ");
        if (spltQuery.length > 1) {
            sQFirst = spltQuery[0];
            sQSecond = spltQuery[1];
        } else {
            sQFirst = spltQuery[0];
            sQSecond = "";
        }
        String formatQuery =
                "SELECT * FROM employees where first_name like '%" + sQFirst + "%' and " +
                        "last_name like '%" + sQSecond + "%'";

        employeesList = processEmpList(formatQuery);

        return employeesList;
    }

    @Override
    public List<Employee> searchID(String searchQuery) {
        System.out.println("search by id started");
        List<Employee> employeesList = new ArrayList<>();


        String formatQuery =
                "SELECT * FROM employees where id = " + searchQuery;
        employeesList = processEmpList(formatQuery);

        return employeesList;
    }

    @Override
    public List<Employee> searchDept(String searchQuery) {
        System.out.println("search by department started");
        int deptID = 0;
        switch (searchQuery.toLowerCase()) {
            case "technology":
                deptID = 1;
                break;
            case "hr":
                deptID = 2;
                break;
            case "finance":
                deptID = 3;
                break;
            case "marketing":
                deptID = 4;
                break;
            case "production":
                deptID = 5;
                break;
            default:
                ;

        }
        List<Employee> employeesList;
        String formatQuery =
                "SELECT * FROM employees where dept_id = " + deptID;
        employeesList = processEmpList(formatQuery);


        return employeesList;

    }

    @Override
    public Employee allInfo(int id) {

        Employee emp = new Employee();
        List<String> team = new ArrayList<>();
        String formatQuery = String.format("select * from employees where id = %d", id);
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(formatQuery);
            if (rs.next()) {
                emp.setFirst_name(rs.getString("first_name"));
                //System.out.println(emp.getFirst_name());
                emp.setLast_name(rs.getString("last_name"));
                //System.out.println(emp.getLast_name());
                emp.setId(rs.getInt("id"));
                //System.out.println(emp.getId()());
//                emp.setTitle(rs.getString("job_title"));
                emp.setHire_date(rs.getDate("hire_date"));
                emp.setGoals(rs.getString("goals"));
                emp.setBio(rs.getString("bio"));
                emp.setJob_id((rs.getInt("job_id")));
            }

            userInfo(id, emp);
            int deptId = rs.getInt("dept_id");
            deptInfo(deptId, emp);
            int jobId = rs.getInt("job_id");
            jobInfo(jobId, emp);
            team = teamList(deptId, emp);
            emp.setTeam(team);



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public Employee deptInfo(int deptId, Employee emp) {
        String query = String.format("select * from departments where id = %d", deptId);
        System.out.println("dept info ran with "+query);
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                emp.setDept_name(rs.getString("name"));
                emp.setManager(rs.getString("manager"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emp;
    }

    @Override
    public Employee userInfo(int id, Employee emp) {
        String query = String.format("select * from users where emp_id = %d", id);
        System.out.println("userInfo ran with "+query);
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                emp.setEmail(rs.getString("email"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    public Employee jobInfo(int jobID, Employee emp){
        String query = String.format("SELECT * FROM titles WHERE id = %d", jobID);
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()){
                emp.setJob_title(rs.getString("name"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return emp;
    }

    //    private static void populateUsersTable(){
//        List<Employee> employeeList = DaoFactory.empListDao().all();
//    }


    @Override
    public long insert(Employee emp) {
        String query = "INSERT INTO ems_db.employees( gender, first_name, last_name, birth_date, hire_date, salary," +
                " bio, goals, dept_id, job_id) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, emp.getGender());
            stmt.setString(2, emp.getFirst_name());
            stmt.setString(3, emp.getLast_name());
            stmt.setDate(4, (Date) emp.getBirth_date());
            stmt.setDate(5, (Date) emp.getHire_date());
            stmt.setDouble(6, emp.getSalary());
            stmt.setString(7, emp.getBio());
            stmt.setString(8, emp.getGoals());
            stmt.setInt(9, emp.getDept_id());
            stmt.setInt(10, emp.getJob_id());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new employee", e);
        }
    }

    private List<String> teamList(int deptId, Employee emp){
        System.out.println("running teamlist");
        List<String> team = new ArrayList<>();
        try{
            String formatQuery = "SELECT first_name, last_name FROM employees where dept_id = " +
                    deptId;
            String firstName = "";
            String lastName = "";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(formatQuery);
            System.out.println("teamList ran with: "+formatQuery);
            while (rs.next()) {

                firstName = rs.getString("first_name");
                lastName = rs.getString("last_name");
                if (!emp.getManager().equalsIgnoreCase(firstName+" "+lastName)) {
                    team.add(String.format("%s %s", firstName, lastName));
                    System.out.println(firstName+" "+lastName+
                            "was added to the list");
                }

            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return team;
    }

    private List<Employee> processEmpList(String formatQuery) {

        List<Employee> employeesList = new ArrayList<Employee>();
        System.out.println(formatQuery);
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(formatQuery);
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setFirst_name(rs.getString("first_name"));
                System.out.println(emp.getFirst_name());
                emp.setLast_name(rs.getString("last_name"));
                System.out.println(emp.getLast_name());
                emp.setId(rs.getInt("id"));
                System.out.println(emp.getId());
                employeesList.add(emp);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeesList;
    }
}