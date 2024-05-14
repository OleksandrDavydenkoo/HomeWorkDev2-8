package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5437/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "password";

    private static Database instance;
    private Connection connection;

    private Database() {
        try {
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        return this.connection;
    }
}
