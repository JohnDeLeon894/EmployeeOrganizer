package dao;

import java.util.List;

public interface Employees {
    List<Employee> all(int perPage, int pageNum);
    List<Employee> all();
    List<Employee> searchName(String searchQuery);
    List<Employee> searchID(String searchQuery);
    List<Employee> searchDept(String searchQuery);
   // List<String> returnTeamList(int deptId, Employee emp);
    Employee allInfo(int id);
    Employee deptInfo(int deptId, Employee emp);
    Employee userInfo(int id, Employee emp);
    Employee jobInfo(int jobID, Employee emp);

    long insert(Employee emp);

}
