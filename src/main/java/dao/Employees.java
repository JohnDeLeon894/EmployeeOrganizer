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
    void updatBio(String bio, int id);
    void updatGoals(String goal, int id);

    long insert(Employee emp);
    void delete(int id);

}
