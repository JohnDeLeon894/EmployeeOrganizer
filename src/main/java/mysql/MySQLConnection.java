package mysql;

import com.mysql.jdbc.Driver;

import java.sql.*;


public class MySQLConnection {
    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new Driver());
            Config config = new Config();
            Connection connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUserName(),
                    config.getPassword()
            );
            Statement statement = connection.createStatement();

            String query = "select first_name, last_name, id from employees limit 10";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                System.out.println(" name = " + rs.getString("first_name")+ " " + rs.getString(
                        "last_name"));
                System.out.println("Emp # = " + rs.getInt( "id"));
            }


        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
