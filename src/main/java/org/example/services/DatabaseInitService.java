package org.example.services;

import org.example.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInitService {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("sql/init_db.sql")));
            String[] queries = content.split(";");

            Connection connection = Database.getInstance().getConnection();

            for (String query : queries) {
                if (!query.trim().isEmpty()) {
                    try (PreparedStatement preparedStatement = connection.prepareStatement(query.trim())) {
                        preparedStatement.executeUpdate();
                    }
                }
            }

            System.out.println("Database initialized successfully.");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}