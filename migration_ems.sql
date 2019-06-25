drop database ems_db;
create database ems_db;

use ems_db;

DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS departments;


CREATE TABLE departments (
                        id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                        name VARCHAR(255) NOT NULL,
                        manager VARCHAR(255) NOT NULL,
                        PRIMARY KEY (id)
);

CREATE TABLE titles (
                        id INT UNSIGNED NOT NULL,
                        name VARCHAR(255) NOT NULL,
                        PRIMARY KEY (id)

);

CREATE TABLE employees (
                        id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                        gender enum('M', 'F') NOT NULL,
                        first_name VARCHAR(255) NOT NULL,
                        last_name VARCHAR(255) NOT NULL,
                        birth_date date NOT NULL,
                        hire_date date NOT NULL,
                        salary double (15,2) NOT NULL,
                        bio VARCHAR(255),
                        goals VARCHAR(255),
                        dept_id INT UNSIGNED NOT NULL,
                        job_id INT UNSIGNED NOT NULL,
                        PRIMARY KEY (id),
                        FOREIGN KEY (dept_id) REFERENCES departments(id),
                        FOREIGN KEY (job_id) REFERENCES titles(id)
);

CREATE TABLE users (
                       id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                       username VARCHAR(240) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL,
                       emp_id INT UNSIGNED NOT NULL,
                       PRIMARY KEY (id),
                       FOREIGN KEY (emp_id) REFERENCES employees(id)
);


