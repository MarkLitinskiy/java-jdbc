package edu.school21.chat.app;

import edu.school21.chat.models.*;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.*;



public class Program {

    public static void main(String[] args) {
        try {
                findAll();
        } catch (SQLException | NotSavedSubEntityException exception) {
            System.out.println(exception);
        }
    }

    private static void findAll() throws SQLException {
        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(DataSource.getConnection());
        for(User user : messagesRepository.findAll(0, 4)){
            System.out.println(user);
        }
    }
}