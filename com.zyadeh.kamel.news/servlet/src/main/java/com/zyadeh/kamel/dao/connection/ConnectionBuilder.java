package com.zyadeh.kamel.dao.connection;
import org.postgresql.Driver;
import java.sql.*;
public class ConnectionBuilder {
    private static Connection connection;
    private static final String url = "jdbc:postgresql://localhost:5432/news";
    private static final String username = "postgres";
    private static final String password = "swrali88";

    private ConnectionBuilder() {
    }
    static {
        try {
            Class.forName("org.postgresql.Driver");
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static Connection getConnection() {
        return connection;
    }
}
