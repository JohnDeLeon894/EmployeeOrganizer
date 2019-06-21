package dao;

import java.util.*;

public class Employee {
    private int emp_no;
    private Date birth_date;
    private String first_name;
    private String last_name;
    private String gender;
    private Date hire_date;
    private String manager_name;
    private String department;
    private String email;
    private String goals;
    private String bio;
    private String title;

    public Employee() {

    }

    public Employee( Date birth_date, String first_name, String last_name, String gender,
                      Date hire_date) {

        this.birth_date = birth_date;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.hire_date = hire_date;
    }

    // getters

    public int getEmp_no() {
        return emp_no;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getGender() {
        return gender;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public String getManager_name() {
        return manager_name;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getGoals() {
        return goals;
    }

    public String getBio() {
        return bio;
    }

    public String getTitle() {
        return title;
    }

    // setters


    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

