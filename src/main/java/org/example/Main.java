package org.example;

import org.example.client.Client;
import org.example.client.ClientService;
import org.flywaydb.core.Flyway;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://localhost:5437/oleksandr-db", "postgres", "password").load();
        flyway.migrate();

        ClientService clientService = new ClientService();

        try {
            long clientId = clientService.create("New Client");
            System.out.println("Created client with ID: " + clientId);

            String clientName = clientService.getById(clientId);
            System.out.println("Client name: " + clientName);

            clientService.setName(clientId, "Updated Client");
            System.out.println("Updated client name: " + clientService.getById(clientId));

            List<Client> clients = clientService.listAll();
            System.out.println("All clients: " + clients);

            clientService.deleteById(clientId);
            System.out.println("Deleted client with ID: " + clientId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
