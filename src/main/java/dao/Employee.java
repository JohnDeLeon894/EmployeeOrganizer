package dao;

import java.util.*;

public class Employee {
    private int id;
    private String gender;
    private String first_name;
    private String last_name;
    private Date birth_date;
    private Date hire_date;
    private double salary;
    private String bio;
    private String goals;
    private int dept_id;
    private int job_id;
    private String manager;
    private String dept_name;
    private String job_title;
    private String email;

    public Employee(int id, String gender, String first_name, String last_name, Date birth_date, Date hire_date,
                    double salary, String bio, String goals, int dept_id, int job_id) {
        this.id = id;
        this.gender = gender;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.hire_date = hire_date;
        this.salary = salary;
        this.bio = bio;
        this.goals = goals;
        this.dept_id = dept_id;
        this.job_id = job_id;
    }
    public Employee( String gender, String first_name, String last_name, Date birth_date, Date hire_date,
                     double salary, String bio, String goals, int dept_id, int job_id) {
        this.gender = gender;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.hire_date = hire_date;
        this.salary = salary;
        this.bio = bio;
        this.goals = goals;
        this.dept_id = dept_id;
        this.job_id = job_id;
    }


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

    public int getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public double getSalary() {
        return salary;
    }

    public String getBio() {
        return bio;
    }

    public String getGoals() {
        return goals;
    }

    public int getDept_id() {
        return dept_id;
    }

    public int getJob_id() {
        return job_id;
    }

    public String getManager() {
        return manager;
    }

    public String getDept_name() {
        return dept_name;
    }

    public String getJob_title() {
        return job_title;
    }

    public String getEmail() {
        return email;
    }

    // setters


    public void setId(int id) {
        this.id = id;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

