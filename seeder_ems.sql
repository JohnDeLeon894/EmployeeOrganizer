use ems_db;


INSERT INTO departments (name, manager)
VALUES ('Technology', 'John Wizard'),
       ('HR', 'Bob Will'),
       ('Finance', 'Zach Frost'),
       ('Marketing', 'Mike Stopper'),
       ('Production', 'Siri Phone');

# SELECT * FROM departments;

INSERT INTO titles (id, name)
VALUES
        (1, 'Clerk'),
        (2, 'Administrator'),
        (3, 'Lead Administrator'),
        (4, 'Programmer'),
        (5, 'Senior Programmer'),
        (6, 'Program Architect'),
        (7, 'Senior Program Architect'),
        (8, 'Accountant'),
        (9, 'Lead Accountant'),
        (10, 'Consultant');

# SELECT * FROM titles;

INSERT INTO employees (gender, first_name, last_name, birth_date, job_id, hire_date, salary, bio, goals, dept_id)
VALUES
       ('M', 'Mykal', 'Tanker', 19920101, 2, 20190101, 45000, 'I come from San Antonio!', 'I want to be good at life', 2),
       ('M', 'John', 'Wizard', 19700119, 5, 20190101, 110000, 'I come from San Antonio!', 'I want to be good at life', 1),
       ('F', 'Elle', 'Archer', 20000101, 6, 20190101, 60000, 'I come from San Antonio!', 'I want to be good at life', 5),
       ('F', 'Zach', 'Frost', 19890218, 9, 20190305, 90000, 'I come from San Antonio!', 'I want to be good at life', 3),
       ('F', 'Mike', 'Stopper', 19820429, 10, 20190220, 60000, 'I come from San Antonio!', 'I want to be good at life', 4),
       ('M', 'Ryan', 'Phone', 19971012, 1, 20190416, 30000, 'I come from San Antonio!', 'I want to be good at life', 2),
       ('M', 'Justin', 'Blanket', 19840930, 4, 20190212, 50000, 'I come from San Antonio!', 'I want to be good at life', 1),
       ('M', 'Josh', 'Banket', 19900718, 8, 20190101, 70000, 'I come from San Antonio!', 'I want to be good at life', 3),
       ('M', 'Bob', 'Will', 19760621, 3, 20190601, 60000, 'I come from San Antonio!', 'I want to be good at life', 2),
       ('F', 'Siri', 'Phone', 19990423, 7, 20190501, 85000, 'I come from San Antonio!', 'I want to be good at life', 5);

# SELECT * FROM employees;
# SELECT * FROM employees WHERE dept_id = 2;


INSERT INTO users (username, password, email, emp_id)
VALUES

       ('Myktank', '$2a$10$/Lrs9koopJu3O2SgWJGpHuwO6A1HYM6c7nVU6eM1h1Gqnqh8hB4Mi', 'Myktank@live.com', 1),
       ('Johnwizard', '$2a$10$/Lrs9koopJu3O2SgWJGpHuwO6A1HYM6c7nVU6eM1h1Gqnqh8hB4Mi', 'Johnwizard@live.com', 2),
       ('ElleA', '$2a$10$/Lrs9koopJu3O2SgWJGpHuwO6A1HYM6c7nVU6eM1h1Gqnqh8hB4Mi', 'ElleA@live.com', 3),
       ('ZachF', '$2a$10$/Lrs9koopJu3O2SgWJGpHuwO6A1HYM6c7nVU6eM1h1Gqnqh8hB4Mi', 'ZachF@live.com', 4),
       ('MikeS', '$2a$10$/Lrs9koopJu3O2SgWJGpHuwO6A1HYM6c7nVU6eM1h1Gqnqh8hB4Mi', 'MikeS@live.com', 5),
       ('RyanP', '$2a$10$/Lrs9koopJu3O2SgWJGpHuwO6A1HYM6c7nVU6eM1h1Gqnqh8hB4Mi', 'RyanP@live.com', 6),
       ('JustinB', '$2a$10$/Lrs9koopJu3O2SgWJGpHuwO6A1HYM6c7nVU6eM1h1Gqnqh8hB4Mi', 'JustinB@live.com', 7),
       ('JoshB', '$2a$10$/Lrs9koopJu3O2SgWJGpHuwO6A1HYM6c7nVU6eM1h1Gqnqh8hB4Mi', 'JoshB@live.com', 8),
       ('Bobwill', '$2a$10$/Lrs9koopJu3O2SgWJGpHuwO6A1HYM6c7nVU6eM1h1Gqnqh8hB4Mi', 'Bobwill@live.com', 9),
       ('Siri', '$2a$10$/Lrs9koopJu3O2SgWJGpHuwO6A1HYM6c7nVU6eM1h1Gqnqh8hB4Mi', 'Siri@live.com', 10);


# SELECT * FROM users;

# ******************

# Possible needed Queries
# ******************
# ******************
# To set up a new manager
# ******************
# UPDATE `ems_db`.`departments` t SET t.`manager` = 'Bob Will' WHERE t.`id` = 2;
# ******************
# ******************
# Get username, password and email from employee
# ******************
# SELECT username, password, email FROM users
# WHERE emp_id IN (
#     SELECT id FROM employees
#     where first_name = 'John'
#     AND last_name = 'Wizard'
#     );
# ******************
# ******************
# Get info of employees who work in HR
# ******************
# SELECT first_name, last_name, job_title, salary FROM employees
# WHERE dept_id IN(
#     SELECT id FROM departments
#     WHERE departments.id = 2
#     );
# ******************
# ******************
# Get all employees under a manager
# ******************
# SELECT CONCAT(first_name, ' ',last_name) as Name, gender, job_title as 'Job Title', id
# FROM employees as e
# WHERE dept_id IN (
#     SELECT id FROM departments
#     WHERE manager = 'Bob Will'
#     ORDER BY e.birth_date
# );


