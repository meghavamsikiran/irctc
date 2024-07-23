package com.irctc.config;

import java.sql.*;

public class DBConnectionUtil {

    public static Connection establishConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/traindb";
        String username = "root";
        String password = "Vamsi@2002";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
}
