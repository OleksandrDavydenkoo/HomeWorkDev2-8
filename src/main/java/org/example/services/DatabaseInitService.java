package org.example.services;

import org.example.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("sql/init_db.sql")));
            String[] queries = content.split(";");

            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();

            for (String query : queries) {
                statement.executeUpdate(query);
            }

            System.out.println("Database initialized successfully.");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
