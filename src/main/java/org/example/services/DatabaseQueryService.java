package org.example.services;

import org.example.Database;
import org.example.model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public List<LongestProject> findLongestProject() {
        List<LongestProject> result = new ArrayList<>();

        try (Connection connection = Database.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            String content = new String(Files.readAllBytes(Paths.get("sql/find_longest_project.sql")));
            try (ResultSet resultSet = statement.executeQuery(content)) {
                while (resultSet.next()) {
                    int projectId = resultSet.getInt("project_id");
                    String projectName = resultSet.getString("project_name");
                    int projectDuration = resultSet.getInt("project_duration");
                    result.add(new LongestProject(projectId, projectName, projectDuration));
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<ProjectClient> findMaxProjectsClient() {
        List<ProjectClient> result = new ArrayList<>();

        try (Connection connection = Database.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            String content = new String(Files.readAllBytes(Paths.get("sql/find_max_projects_client.sql")));
            try (ResultSet resultSet = statement.executeQuery(content)) {
                while (resultSet.next()) {
                    int clientId = resultSet.getInt("client_id");
                    String clientName = resultSet.getString("client_name");
                    int maxProjects = resultSet.getInt("max_projects");
                    result.add(new ProjectClient(clientId, clientName, maxProjects));
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<WorkerSalary> findMaxSalaryWorker() {
        List<WorkerSalary> result = new ArrayList<>();

        try (Connection connection = Database.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            String content = new String(Files.readAllBytes(Paths.get("sql/find_max_salary_worker.sql")));
            try (ResultSet resultSet = statement.executeQuery(content)) {
                while (resultSet.next()) {
                    int workerId = resultSet.getInt("worker_id");
                    String workerName = resultSet.getString("worker_name");
                    double maxSalary = resultSet.getDouble("max_salary");
                    result.add(new WorkerSalary(workerId, workerName, maxSalary));
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<WorkerAge> findYoungestEldestWorkers() {
        List<WorkerAge> result = new ArrayList<>();

        try (Connection connection = Database.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            String content = new String(Files.readAllBytes(Paths.get("sql/find_youngest_eldest_workers.sql")));
            try (ResultSet resultSet = statement.executeQuery(content)) {
                while (resultSet.next()) {
                    int workerId = resultSet.getInt("worker_id");
                    String workerName = resultSet.getString("worker_name");
                    int workerAge = resultSet.getInt("worker_age");
                    result.add(new WorkerAge(workerId, workerName, workerAge));
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<ProjectPrice> printProjectPrices() {
        List<ProjectPrice> result = new ArrayList<>();

        try (Connection connection = Database.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            String content = new String(Files.readAllBytes(Paths.get("sql/print_project_prices.sql")));
            try (ResultSet resultSet = statement.executeQuery(content)) {
                while (resultSet.next()) {
                    String projectName = resultSet.getString("project_name");
                    double projectPrice = resultSet.getDouble("project_price");
                    result.add(new ProjectPrice(projectName, projectPrice));
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}