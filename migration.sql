use employees;

CREATE TABLE users (
                       id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                       username VARCHAR(240) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL,
                       bio VARCHAR(255) NOT NULL,
                       goals VARCHAR(255) NOT NULL,
                       emp_no INT NOT NULL,
                       PRIMARY KEY (id),
                       FOREIGN KEY (emp_no) REFERENCES employees(emp_no)
