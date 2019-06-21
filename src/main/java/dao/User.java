package dao;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private int emp_id;

    public User() {}

    public User(String username, String password, String email, int emp_id) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.emp_id = emp_id;
    }

    public User(int id, String username, String password, String email, int emp_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.emp_id = emp_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }
}

