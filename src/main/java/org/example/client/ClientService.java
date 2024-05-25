package org.example.client;

import org.example.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

public class ClientService {

    public long create(String name) throws SQLException {
        if (name == null || name.length() < 2 || name.length() > 255) {
            throw new IllegalArgumentException("Client name must be between 2 and 255 characters");
        }

        String query = "INSERT INTO client (name) VALUES (?) RETURNING id";
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getLong(1);
            } else {
                throw new SQLException("Failed to create client");
            }
        }
    }

    public String getById(long id) throws SQLException {
        String query = "SELECT name FROM client WHERE id = ?";
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("name");
            } else {
                throw new SQLException("Client not found");
            }
        }
    }

    public void setName(long id, String name) throws SQLException {
        if (name == null || name.length() < 2 || name.length() > 255) {
            throw new IllegalArgumentException("Client name must be between 2 and 255 characters");
        }

        String query = "UPDATE client SET name = ? WHERE id = ?";
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, id);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Client not found");
            }
        }
    }

    public void deleteById(long id) throws SQLException {
        String query = "DELETE FROM client WHERE id = ?";
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted == 0) {
                throw new SQLException("Client not found");
            }
        }
    }

    public List<Client> listAll() throws SQLException {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT id, name FROM client";
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                clients.add(new Client(resultSet.getLong("id"), resultSet.getString("name")));
            }
        }
        return clients;
    }
}