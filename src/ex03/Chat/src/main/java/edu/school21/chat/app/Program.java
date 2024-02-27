package edu.school21.chat.app;

import edu.school21.chat.models.*;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;


public class Program {

    public static void main(String[] args) {
        try {
                updateMessageToDataBase();

        } catch (SQLException | NotSavedSubEntityException exception) {
            System.out.println(exception);
        }
    }

    private static void updateMessageToDataBase() throws SQLException {
        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(DataSource.getConnection());
        Message message = new Message(17L, 1L, 1L, "abobalonef", LocalDateTime.now());
        messagesRepository.update(message);
        //messagesRepository.findById(11L);
    }
}