package dao;

import java.util.List;

public interface Employees {
    List<Employee> all(int perPage, int pageNum);
    List<Employee> all();
    List<Employee> searchName(String searchQuery);
    List<Employee> searchID(String searchQuery);
    List<Employee> searchDept(String searchQuery);

    long insert(Employee emp);

}
