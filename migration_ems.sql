create database ems_db;

use ems_db;

DROP TABLE IF EXISTS departments;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS users;

CREATE TABLE departments (
                        id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                        name VARCHAR(255) NOT NULL,
                        manager VARCHAR(255) NOT NULL,
                        PRIMARY KEY (id)
);

CREATE TABLE employees (
                        id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                        gender enum('M', 'F') NOT NULL,
                        first_name VARCHAR(255) NOT NULL,
                        last_name VARCHAR(255) NOT NULL,
                        birth_date date NOT NULL,
                        job_title VARCHAR(255) NOT NULL,
                        hire_date date NOT NULL,
                        salary double (15,2) NOT NULL,
                        dept_id INT UNSIGNED NOT NULL,
                        PRIMARY KEY (id),
                        FOREIGN KEY (dept_id) REFERENCES departments(id)
);

CREATE TABLE users (
                       id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                       username VARCHAR(240) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL,
                       bio VARCHAR(255) NOT NULL,
                       goals VARCHAR(255) NOT NULL,
                       emp_id INT UNSIGNED NOT NULL,
                       PRIMARY KEY (id),
                       FOREIGN KEY (emp_id) REFERENCES employees(id)
);

