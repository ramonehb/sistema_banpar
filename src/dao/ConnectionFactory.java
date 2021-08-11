package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {
    private static String connectionString = "jdbc:mysql://localhost:3306";
    private static String user = "root";
    private static String pass = "1234";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(connectionString,user,pass);
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

}

