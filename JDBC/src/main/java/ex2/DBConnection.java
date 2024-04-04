package ex2;


import java.sql.*;
public class DBConnection {
    private static Connection connection;
    public static Connection getConnection() {
        if (connection == null) {
            try {
            String url = "jdbc:mariadb://localhost:3306/jdbcex";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
            System.err.println("Connection cannot be established");
            e.printStackTrace();
        }
        }
        return connection;
    }
}
