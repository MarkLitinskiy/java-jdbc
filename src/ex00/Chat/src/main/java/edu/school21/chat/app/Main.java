package edu.school21.chat.app;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/abalonef";
        String user = "abalonef";
        String passwd = "aboba";

        try (Connection connection = DriverManager.getConnection(url, user, passwd)) {
            String query = "select * from chat_database.users";
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(query)) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String login = resultSet.getString("user_login");
                        String password = resultSet.getString("user_password");
                        System.out.println("ID: " + id + ", Login: " + login + ", Password: " + password);
                    }
                }
            }
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }
}