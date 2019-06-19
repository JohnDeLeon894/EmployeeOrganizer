use ems_db;

# DROP TABLE departments;
# TRUNCATE employees;
# TRUNCATE users;



INSERT INTO departments (name, manager)
VALUES ('Technology', 'John Wizard'),
       ('HR', 'Bob Will'),
       ('Finance', 'Zach Frost'),
       ('Marketing', 'Mike Stopper'),
       ('Production', 'Siri Phone');

# SELECT * FROM departments;

INSERT INTO employees (gender, first_name, last_name, birth_date, job_title, hire_date, salary, dept_id)
VALUES
       ('M', 'Mykal', 'Tanker', 19920101, 'Administrator', 20190101, 45000, 2),
       ('M', 'John', 'Wizard', 19700119, 'Senior Programmer', 20190101, 110000, 1),
       ('F', 'Elle', 'Archer', 20000101, 'Program Architect', 20190101, 60000, 5),
       ('F', 'Zach', 'Frost', 19890218, 'Lead Accountant', 20190305, 90000, 3),
       ('F', 'Mike', 'Stopper', 19820429, 'Consultant', 20190220, 60000, 4),
       ('F', 'Ryan', 'Phone', 19971012, 'Clerk', 20190416, 30000, 2),
       ('F', 'Justin', 'Blanket', 19840930, 'Programmer', 20190212, 50000, 1),
       ('F', 'Josh', 'Banket', 19900718, 'Accountant', 20190101, 70000, 3),
       ('F', 'Bob', 'Will', 19760621, 'Lead Administrator', 20190601, 60000, 2),
       ('F', 'Siri', 'Phone', 19990423, 'Senior Program Architect', 20190501, 85000, 5);

# SELECT * FROM employees;
# SELECT * FROM employees WHERE dept_id = 2;

INSERT INTO users (username, password, email, bio, goals, emp_id)
VALUES
       ('Myktank', 'codeup', 'Myktank@live.com', 'how am i so good at life', 'I want to learn', 1),
       ('Johnwizard', 'codeup', 'Johnwizard@live.com', 'how am i not so good at life', 'I want to
learn', 2),
       ('ElleA', 'codeup', 'ElleA@live.com', 'how am i amazingly good at life', 'I want to know',
        3),
       ('ZachF', 'codeup', 'ZachF@live.com', 'how am i life', 'I want to see', 4),
       ('MikeS', 'codeup', 'MikeS@live.com', 'how i  life', 'I want to hear', 5),
       ('RyanP', 'codeup', 'RyanP@live.com', 'how am i', 'I want you to know', 6),
       ('JustinB', 'codeup', 'JustinB@live.com', 'how am i good', 'I want you to hear', 7),
       ('JoshB', 'codeup', 'JoshB@live.com', 'how am i amazingly', 'I want to jump alot', 8),
       ('Bobwill', 'codeup', 'Bobwill@live.com', 'how am i at life', 'I want progress', 9),
       ('Siri', 'codeup', 'Siri@live.com', 'how am i amazingly good at life', 'I want to
success', 10);

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


