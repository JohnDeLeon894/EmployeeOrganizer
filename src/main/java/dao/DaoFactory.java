package dao;

import mysql.Config;

public class DaoFactory {
    private static Users usersDao;
    protected static Config config = new Config();
    private static Employees empListDao;

    public static Employees empListDao() {
        if (empListDao == null) {
            empListDao = new EmployeesDao();
        }
        return empListDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }
}