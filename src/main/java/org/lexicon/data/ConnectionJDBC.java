package org.lexicon.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/shopping_practise";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "root1234";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    JDBC_URL,
                    JDBC_USERNAME,
                    JDBC_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
